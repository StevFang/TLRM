package com.ddmh.mq;

import com.alibaba.fastjson.JSON;
import com.ddmh.dto.CdcSqlMessageDto;
import com.ddmh.model.RocketmqEvent;
import com.ddmh.utils.JsonUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.ddmh.enums.CdcSqlMessageTypeEnum.Update;


/**
 * 监听消息进行消费
 *
 * @author fbin
 */
@Component
public class ConsumerService {

    @EventListener(condition = "#event.msgs[0].topic=='user-topic' && #event.msgs[0].tags=='white'")
    public void rocketMQMsgListen(RocketmqEvent event) {
      DefaultMQPushConsumer consumer = event.getConsumer();
        try {
            CdcSqlMessageDto cdcSqlMessage = JSON.parseObject(event.getMsgs().get(0).getBody(), CdcSqlMessageDto.class);
            System.out.println(cdcSqlMessage.getMessageType().getLabel());
            switch (cdcSqlMessage.getMessageType()){
                case Update:
                    System.out.println("consumerService 的消息到达：" + event.getMsgs().get(0).getMsgId());
                    System.out.println("消息体：" + JsonUtils.toJsonStr(cdcSqlMessage));
                    break;
                    default:
            }
            // TODO 进行业务处理

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
