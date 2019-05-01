package com.ddmh.job;

import com.ddmh.dto.CdcSqlMessageDto;
import com.ddmh.dto.ICdcSqlMessage;
import com.ddmh.service.CdcMessageLoadService;
import com.ddmh.service.CdcMessageSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * cdc job
 *
 * @author fbin
 * @version 2019/5/1 0001 22:14
 */
@Slf4j
@Component
public class CdcJob {

    @Autowired
    private CdcMessageLoadService cdcMessageLoadService;

    @Autowired
    private CdcMessageSendService cdcMessageSendService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void execute(){
        log.info("cdc job start. ");

        String filter = "brant_test\\..*";
        List<CdcSqlMessageDto> sqlMessageList = cdcMessageLoadService.loadCdcMessage(filter);
        if(!CollectionUtils.isEmpty(sqlMessageList)){
            for(CdcSqlMessageDto cdcSqlMessage : sqlMessageList){
                cdcMessageSendService.sendCdcMessage(cdcSqlMessage);
            }
        }
    }

}
