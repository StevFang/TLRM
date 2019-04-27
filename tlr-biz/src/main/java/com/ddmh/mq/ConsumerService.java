package com.ddmh.mq;

import com.alibaba.fastjson.JSON;
import com.ddmh.dto.SelectItemDto;
import com.ddmh.model.RocketmqEvent;
import com.ddmh.utils.JsonUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


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
            SelectItemDto selectItemDto = JSON.parseObject(event.getMsgs().get(0).getBody(), SelectItemDto.class);
            System.out.println("consumerService 监听到一个消息达到：" + event.getMsgs().get(0).getMsgId() +", 消息体：" + JsonUtils.toJsonStr(selectItemDto));

            // TODO 进行业务处理
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
