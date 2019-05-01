package com.ddmh.service;

import com.ddmh.dto.CdcSqlMessageDto;

import java.util.List;

/**
 * load cdc message service interface
 *
 * @author fbin
 * @version 2019/5/1 0001 19:27
 */
public interface CdcMessageLoadService {

    /**
     * 加载 sql cdc message
     *
     * @param filter 监听的数据库及表的过滤表达式
     * @return 消息
     */
    List<CdcSqlMessageDto> loadCdcMessage(String filter);

}
