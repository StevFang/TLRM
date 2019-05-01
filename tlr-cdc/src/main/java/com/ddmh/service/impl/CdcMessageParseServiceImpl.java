package com.ddmh.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ddmh.dto.CdcSqlMessageDto;
import com.ddmh.dto.ColumnValueDto;
import com.ddmh.dto.ddl.RenameTableDto;
import com.ddmh.dto.dml.UpdateDataDto;
import com.ddmh.service.CdcMessageParseService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * cdc message parse service impl
 *
 * @author fbin
 * @version 2019/5/1 0001 22:00
 */
@Slf4j
@Service
public class CdcMessageParseServiceImpl implements CdcMessageParseService {

    @Override
    public CdcSqlMessageDto getDataUpdateMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        String db = entry.getHeader().getSchemaName();
        String table = entry.getHeader().getTableName();
        Date timestamp = new Date(entry.getHeader().getExecuteTime());
        String recordId = "";

        UpdateDataDto updateDataDto = UpdateDataDto.builder().db(db).table(table).timestamp(timestamp).build();

        List<ColumnValueDto> columnValueDtoList = Lists.newArrayList();

        for (CanalEntry.RowData rowData : rowChange.getRowDatasList()){
            Map<String, ColumnValueDto> columnValueDtoMap = Maps.newHashMap();

            List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
            for(CanalEntry.Column column : beforeColumnsList){
                columnValueDtoMap.put(column.getName(),
                        ColumnValueDto.builder().column(column.getName()).before(column.getValue()).build());
                if(column.getIsKey()){
                    recordId = column.getValue();
                }
            }

            List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
            for(CanalEntry.Column column : afterColumnsList){
                ColumnValueDto columnValueDto = columnValueDtoMap.get(column.getName());
                columnValueDto.setAfter(column.getValue());
                columnValueDtoList.add(columnValueDto);
            }

        }

        updateDataDto.setRecordId(recordId);
        updateDataDto.setColumnValueDtoList(columnValueDtoList);

        return CdcSqlMessageDto.builder().updateDataDto(updateDataDto).messageType(updateDataDto.getMessageType()).build();
    }

    @Override
    public CdcSqlMessageDto getDataCreateMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        return null;
    }

    @Override
    public CdcSqlMessageDto getIndexCreateMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        return null;
    }

    @Override
    public CdcSqlMessageDto getDataDeleteMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        return null;
    }

    @Override
    public CdcSqlMessageDto getIndexDropMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        return null;
    }

    @Override
    public CdcSqlMessageDto getTableRenameMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        String db = entry.getHeader().getSchemaName();
        String table = entry.getHeader().getTableName();
        Date timestamp = new Date(entry.getHeader().getExecuteTime());

        RenameTableDto renameTableDto = RenameTableDto.builder().db(db).table(table).timestamp(timestamp).build();

        return CdcSqlMessageDto.builder().renameTableDto(renameTableDto).messageType(renameTableDto.getMessageType()).build();
    }

    @Override
    public CdcSqlMessageDto getTableCreateMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        return null;
    }

    @Override
    public CdcSqlMessageDto getTableAlterMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        return null;
    }

    @Override
    public CdcSqlMessageDto getTableDropMessage(CanalEntry.Entry entry, CanalEntry.RowChange rowChange) {
        return null;
    }

}
