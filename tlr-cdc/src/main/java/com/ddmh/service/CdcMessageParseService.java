package com.ddmh.service;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ddmh.dto.CdcSqlMessageDto;

/**
 * sql cdc message parse service interface
 *
 * @author fbin
 * @version 2019/5/1 0001 22:00
 */
public interface CdcMessageParseService {

    /**
     * 获取数据更新的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getDataUpdateMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

    /**
     * 获取数据创建的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getDataCreateMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

    /**
     * 获取索引创建的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getIndexCreateMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

    /**
     * 获取数据删除的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getDataDeleteMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

    /**
     * 获取索引变更的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getIndexDropMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

    /**
     * 获取表名变更的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getTableRenameMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

    /**
     * 获取表创建的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getTableCreateMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

    /**
     * 获取表变更的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getTableAlterMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

    /**
     * 获取表删除的消息体
     *
     * @param entry
     * @param rowChange
     * @return
     */
    CdcSqlMessageDto getTableDropMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange);

}
