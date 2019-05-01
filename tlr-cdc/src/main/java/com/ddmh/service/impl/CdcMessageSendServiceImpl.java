package com.ddmh.service.impl;

import com.alibaba.fastjson.JSON;
import com.ddmh.dto.CdcSqlMessageDto;
import com.ddmh.service.CdcMessageSendService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cdc message send service impl
 *
 * @author fbin
 * @version 2019/5/1 0001 21:16
 */
@Slf4j
@Service
public class CdcMessageSendServiceImpl implements CdcMessageSendService {

    @Autowired
    private DefaultMQProducer defaultProducer;

    @Override
    public void sendCdcMessage(CdcSqlMessageDto cdcSqlMessage) {
        if(cdcSqlMessage != null){
            String json = JSON.toJSONString(cdcSqlMessage);
            Message msg = new Message("user-topic","white", json.getBytes());
            try {
                SendResult sendResult = defaultProducer.send(msg);
                if(!SendStatus.SEND_OK.equals(sendResult.getSendStatus())){
                    log.info("send cdc message failed. ", sendResult.getSendStatus());
                }
            } catch (Exception e) {
                log.error("send cdc message error. ", e);
            }
        }
    }
}
