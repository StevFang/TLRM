package com.ddmh.service;

import com.ddmh.dto.CdcSqlMessageDto;

/**
 * cdc message send service interface
 *
 * @author fbin
 * @version 2019/5/1 0001 21:12
 */
public interface CdcMessageSendService {

    /**
     * 推送 sql cdc message
     *
     * @param cdcSqlMessage
     */
    void sendCdcMessage(CdcSqlMessageDto cdcSqlMessage);

}
