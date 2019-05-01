package com.ddmh.service.impl;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.ddmh.dto.CdcSqlMessageDto;
import com.ddmh.dto.ICdcSqlMessage;
import com.ddmh.service.CdcMessageLoadService;
import com.ddmh.service.CdcMessageParseService;
import com.google.common.collect.Lists;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * sql cdc message service impl
 *
 * @author fbin
 * @version 2019/5/1 0001 20:57
 */
@Slf4j
@Service
public class CdcMessageServiceImpl implements CdcMessageLoadService {

    @Autowired
    private CanalConnector singleCanalConnector;

    @Autowired
    private CdcMessageParseService cdcMessageParseService;

    @Override
    public List<CdcSqlMessageDto> loadCdcMessage(String filter) {
        int batchSize = 1000;
        singleCanalConnector.subscribe(filter);
        Message message = singleCanalConnector.getWithoutAck(batchSize);
        return parseMessage(message);
    }

    /**
     * 解析cdc binlog 消息体
     *
     * @param message
     * @return
     */
    private List<CdcSqlMessageDto> parseMessage(Message message) {
        List<CanalEntry.Entry> canalEntryList = message.getEntries();
        if(!CollectionUtils.isEmpty(canalEntryList)){

            List<CdcSqlMessageDto> sqlMessageList = Lists.newArrayList();
            for(CanalEntry.Entry entry : canalEntryList){
                switch (entry.getEntryType()){
                    case ROWDATA:
                        CdcSqlMessageDto cdcSqlMessage = parseRowData(entry);
                        if(cdcSqlMessage != null){
                            sqlMessageList.add(cdcSqlMessage);
                        }
                        break;
                    case GTIDLOG:
                    case HEARTBEAT:
                    case TRANSACTIONBEGIN:
                    case TRANSACTIONEND:
                    default:
                        break;
                }
            }
            return sqlMessageList;
        }
        return null;
    }

    /**
     * 解析 row data 类型的 binlog 消息
     *
     * @param entry
     * @return
     */
    private CdcSqlMessageDto parseRowData(CanalEntry.Entry entry) {
        CdcSqlMessageDto cdcSqlMessage = null;
        try {
            CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            CanalEntry.EventType eventType = rowChange.getEventType();

            switch (eventType){
                case CREATE:
                    cdcSqlMessage = cdcMessageParseService.getTableCreateMessage(entry, rowChange);
                    break;
                case ALTER:
                    cdcSqlMessage = cdcMessageParseService.getTableAlterMessage(entry, rowChange);
                    break;
                case ERASE:
                    cdcSqlMessage = cdcMessageParseService.getTableDropMessage(entry, rowChange);
                    break;
                case RENAME:
                    cdcSqlMessage = cdcMessageParseService.getTableRenameMessage(entry, rowChange);
                    break;
                case CINDEX:
                    cdcSqlMessage = cdcMessageParseService.getIndexCreateMessage(entry, rowChange);
                    break;
                case DINDEX:
                    cdcSqlMessage = cdcMessageParseService.getIndexDropMessage(entry, rowChange);
                    break;
                case INSERT:
                    cdcSqlMessage = cdcMessageParseService.getDataCreateMessage(entry, rowChange);
                    break;
                case UPDATE:
                    cdcSqlMessage = cdcMessageParseService.getDataUpdateMessage(entry, rowChange);
                    break;
                case DELETE:
                    cdcSqlMessage = cdcMessageParseService.getDataDeleteMessage(entry, rowChange);
                    break;
                case TRUNCATE:
                    cdcSqlMessage = cdcMessageParseService.getDataDeleteMessage(entry, rowChange);
                    break;
                    default:
                        log.info("parse eventType:{} not support", eventType);
            }
        } catch (InvalidProtocolBufferException e) {
            log.error("parse row data error. ", e);
        }
        return cdcSqlMessage;
    }

}
