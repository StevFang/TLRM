package com.ddmh.service.mq;

import com.ddmh.mq.RocketmqEvent;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


/**
 * 监听消息进行消费
 */
@Service
public class ConsumerService {

    @EventListener(condition = "#event.msgs[0].topic=='TopicTest1' && #event.msgs[0].tags=='TagA'")
    public void rocketMQMsgListen(RocketmqEvent event) {
      DefaultMQPushConsumer consumer = event.getConsumer();
        try {
            System.out.println("com.guosen.client.controller.consumerDemo监听到一个消息达到：" + event.getMsgs().get(0).getMsgId());
            // TODO 进行业务处理
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
