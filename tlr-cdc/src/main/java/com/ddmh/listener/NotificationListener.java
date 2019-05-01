package com.ddmh.listener;

import com.ddmh.model.LogEvent;
import com.google.code.or.binlog.BinlogEventListener;
import com.google.code.or.binlog.BinlogEventV4;
import com.google.code.or.binlog.impl.event.DeleteRowsEvent;
import com.google.code.or.binlog.impl.event.UpdateRowsEvent;
import com.google.code.or.binlog.impl.event.WriteRowsEvent;
import com.google.code.or.common.glossary.Column;
import com.google.code.or.common.glossary.Pair;
import com.google.code.or.common.glossary.Row;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * binlog事件监听
 *
 * @author fbin
 * @version 2019/4/27 0027 18:12
 */
@Slf4j
@Component
public class NotificationListener implements BinlogEventListener {

    private String host="xx.xx.xx.xx";
    private Integer port=3306;
    private String username="root";
    private String password="root";

    @Override
    public void onEvents(BinlogEventV4 event) {
        if(event == null){
            log.error("binlog event is null");
            return;
        }

        if(event instanceof UpdateRowsEvent){
            UpdateRowsEvent updateRowsEvent = (UpdateRowsEvent)event;

            LogEvent logEvent = new LogEvent(updateRowsEvent);

            List<Pair<Row>> rows = updateRowsEvent.getRows();
            List<Column> colsAfter = null;
            List<Column> colsBefore = null;
            for(Pair<Row> p : rows){
                Row after = p.getAfter();
                Row before = p.getBefore();
                colsAfter = after.getColumns();
                colsBefore = before.getColumns();
                break;
            }
            logEvent.setBefore(getMap(colsBefore, updateRowsEvent.getTableId()));
            logEvent.setAfter(getMap(colsAfter, updateRowsEvent.getTableId()));

            log.info("update event is:"+logEvent);
        }else if(event instanceof DeleteRowsEvent){
            DeleteRowsEvent deleteRowsEvent = (DeleteRowsEvent)event;
            LogEvent logEvent = new LogEvent(deleteRowsEvent);
            List<Row> rows = deleteRowsEvent.getRows();
            List<Column> before = null;
            for(Row row:rows){
                before = row.getColumns();
                break;
            }
            logEvent.setBefore(getMap(before, deleteRowsEvent.getTableId()));

            log.info("delete event is:"+logEvent);

        }else if(event instanceof WriteRowsEvent){
            WriteRowsEvent writeRowsEvent = (WriteRowsEvent)event;
            LogEvent logEvent = new LogEvent(writeRowsEvent);
            List<Row> rows = writeRowsEvent.getRows();
            List<Column> before = null;
            for(Row row:rows){
                before = row.getColumns();
                break;
            }
            logEvent.setAfter(getMap(before, writeRowsEvent.getTableId()));
            log.info("write event is:"+logEvent);
        }
    }

    private Map<String, String> getMap(List<Column> cols, Long tableId) {
        Map<String, String> map = Maps.newHashMap();
        if(!CollectionUtils.isEmpty(cols)){
            for(Column column : cols){
                map.put(String.valueOf(tableId), column.toString());
            }
        }
        return map;
    }

}
