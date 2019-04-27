package com.ddmh.config;

import com.ddmh.mq.RocketmqEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 通过使用指定的文件读取类 来加载配置文件到字段中
 *
 * @author fbin
 * @version 2019/4/26
 *
 */
@Configuration
@EnableConfigurationProperties(RocketmqProperties.class)
@Slf4j
public class RocketmqConfiguration {

    @Autowired
    private RocketmqProperties rocketmqProperties;

    /**
     * 事件监听
     */
    @Autowired
    private ApplicationEventPublisher publisher = null;

    private static boolean isFirstSub = true;

    private static long startTime = System.currentTimeMillis();

    /**
     * 容器初始化的时候 打印参数
     */
    @PostConstruct
    public void init() {
        log.info("nameSrvAddr :{}", rocketmqProperties.getNameSrvAddr());
        log.info("producerGroupName :{}", rocketmqProperties.getProducerGroupName());
        log.info("consumerBatchMaxSize :{}", rocketmqProperties.getConsumerBatchMaxSize());
        log.info("consumerGroupName :{}", rocketmqProperties.getConsumerGroupName());
        log.info("consumerInstanceName :{}", rocketmqProperties.getConsumerInstanceName());
        log.info("producerInstanceName :{}", rocketmqProperties.getProducerInstanceName());
        log.info("producerTransInstanceName :{}", rocketmqProperties.getProducerTranInstanceName());
        log.info("transactionProducerGroupName :{}", rocketmqProperties.getTransactionProducerGroupName());
        log.info("consumerBroadcasting :{}", rocketmqProperties.isConsumerBroadcasting());
        log.info("enableHistoryConsumer :{}", rocketmqProperties.isEnableHistoryConsumer());
        log.info("enableOrderConsumer :{}", rocketmqProperties.isEnableOrderConsumer());
        log.info("subscribe [0] :{}", rocketmqProperties.getSubscribe().get(0));
    }

    /**
     * 创建普通消息发送者实例
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQProducer defaultProducer() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(
                rocketmqProperties.getProducerGroupName());
        producer.setNamesrvAddr(rocketmqProperties.getNameSrvAddr());
        producer.setInstanceName(rocketmqProperties.getProducerInstanceName());
        producer.setVipChannelEnabled(false);
        producer.setRetryTimesWhenSendAsyncFailed(10);
        producer.start();
        log.info("rocketmq producer server is starting....");
        return producer;
    }

    /**
     * 创建支持消息事务发送的实例
     * @return
     * @throws MQClientException
     */
    @Bean
    public TransactionMQProducer transactionProducer() throws MQClientException {
        TransactionMQProducer producer = new TransactionMQProducer(
                rocketmqProperties.getTransactionProducerGroupName());
        producer.setNamesrvAddr(rocketmqProperties.getNameSrvAddr());
        producer.setInstanceName(rocketmqProperties
                .getProducerTranInstanceName());
        producer.setRetryTimesWhenSendAsyncFailed(10);
        // 事务回查最小并发数
        producer.setCheckThreadPoolMinSize(2);
        // 事务回查最大并发数
        producer.setCheckThreadPoolMaxSize(2);
        // 队列数
        producer.setCheckRequestHoldMax(2000);
        producer.start();
        log.info("rocketmq transaction producer server is starting....");
        return producer;
    }

    /**
     * 创建消息消费的实例
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQPushConsumer pushConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
                rocketmqProperties.getConsumerGroupName());
        consumer.setNamesrvAddr(rocketmqProperties.getNameSrvAddr());
        consumer.setInstanceName(rocketmqProperties.getConsumerInstanceName());

        //判断是否是广播模式
        if (rocketmqProperties.isConsumerBroadcasting()) {
            consumer.setMessageModel(MessageModel.BROADCASTING);
        }
        //设置批量消费
        consumer.setConsumeMessageBatchMaxSize(rocketmqProperties
                .getConsumerBatchMaxSize() == 0 ? 1 : rocketmqProperties
                .getConsumerBatchMaxSize());

        //获取topic和tag
        List<String> subscribeList = rocketmqProperties.getSubscribe();
        for (String sunScribe : subscribeList) {
            consumer.subscribe(sunScribe.split(":")[0], sunScribe.split(":")[1]);
        }

        // 顺序消费
        if (rocketmqProperties.isEnableOrderConsumer()) {
            consumer.registerMessageListener(new MessageListenerOrderly() {
                @Override
                public ConsumeOrderlyStatus consumeMessage(
                        List<MessageExt> messageExtList, ConsumeOrderlyContext context) {
                    try {
                        context.setAutoCommit(true);
                        messageExtList = filterMessage(messageExtList);
                        if (messageExtList.size() == 0)
                            return ConsumeOrderlyStatus.SUCCESS;
                        publisher.publishEvent(new RocketmqEvent(messageExtList, consumer));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                    }
                    return ConsumeOrderlyStatus.SUCCESS;
                }
            });
        }
        // 并发消费
        else {

            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(
                        List<MessageExt> messageExtList,
                        ConsumeConcurrentlyContext context) {
                    try {
                        //过滤消息
                        messageExtList = filterMessage(messageExtList);
                        if (messageExtList.size() == 0)
                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                        publisher.publishEvent(new RocketmqEvent(messageExtList, consumer));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }

                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);

                    try {
                        consumer.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    log.info("rocketmq consumer server is starting....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        return consumer;
    }

    /**
     * 消息过滤
     * @param msgs
     * @return
     */
    private List<MessageExt> filterMessage(List<MessageExt> msgs) {
        if (isFirstSub && !rocketmqProperties.isEnableHistoryConsumer()) {
            msgs = msgs.stream()
                    .filter(item -> startTime - item.getBornTimestamp() < 0)
                    .collect(Collectors.toList());
        }
        if (isFirstSub && msgs.size() > 0) {
            isFirstSub = false;
        }
        return msgs;
    }

}
