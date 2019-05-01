package com.ddmh.model;

import com.google.code.or.binlog.BinlogEventV4;
import com.google.code.or.binlog.BinlogEventV4Header;
import com.google.code.or.binlog.impl.event.AbstractBinlogEventV4;
import com.google.code.or.binlog.impl.event.AbstractRowEvent;
import com.google.code.or.binlog.impl.event.QueryEvent;
import com.google.code.or.binlog.impl.event.TableMapEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

/**
 * bin-log event
 *
 * @author fbin
 * @version 2019/4/27 0027 17:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogEvent implements Serializable {

    /**
     * 只针对delete、insert、update事件
     */
    private static final long serialVersionUID = -1L;

    private String eventId = null;

    private Long tableId;

    private String databaseName = null;
    private String tableName = null;

    private int eventType;
    private int flags;

    private Long timestamp = null;
    private Long timestampRecepite = null;
    private String binlogName = null;
    private Long position = null;
    private Long nextPosition = null;
    private Long serverId = null;
    private Map<String, String> before = null;
    private Map<String, String> after = null;

    public LogEvent(final AbstractRowEvent abstractRowEvent) {
        this.init(abstractRowEvent);
        this.tableId = abstractRowEvent.getTableId();
    }

    public LogEvent(final TableMapEvent tableMapEvent) {
        this.init(tableMapEvent);
        this.tableId = tableMapEvent.getTableId();

        this.databaseName = tableMapEvent.getDatabaseName().toString();
        this.tableName = tableMapEvent.getTableName().toString();
    }

    private void init(final AbstractBinlogEventV4 abstractBinlogEventV4) {
        this.eventId = UUID.randomUUID().toString();
        BinlogEventV4Header header = abstractBinlogEventV4.getHeader();

        this.position = header.getPosition();
        this.nextPosition = header.getNextPosition();
        this.timestamp = header.getTimestamp();
        this.timestampRecepite = header.getTimestampOfReceipt();
        this.serverId = header.getServerId();

        this.eventType = header.getEventType();
        this.flags = header.getFlags();
    }


    @Override
    public String toString() {
        String str = "";
        str += "{ eventId:" + eventId;
        str += ",databaseName:" + databaseName;
        str += ",tableName:" + tableName;
        str += ",eventType:" + eventType;
        str += ",timestamp:" + timestamp;
        str += ",timestampRecepite:" + timestampRecepite;
        str += ",binlogName:" + binlogName;
        str += ",position:" + position;
        str += ",nextPosition:" + nextPosition;
        str += ",serverId:" + serverId;
        str += ",before:" + before;
        str += ",after:" + after + " }";
        return str;
    }

}
