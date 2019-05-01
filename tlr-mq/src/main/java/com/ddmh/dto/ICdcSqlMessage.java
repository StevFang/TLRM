package com.ddmh.dto;

import com.ddmh.enums.CdcSqlMessageTypeEnum;

/**
 * cdc sql message interface
 *
 * @author fbin
 * @version 2019/5/1 0001 20:04
 */
public interface ICdcSqlMessage {

    /**
     * 获取 cdc 消息类型
     *
     * @return
     */
    CdcSqlMessageTypeEnum getMessageType();

}
