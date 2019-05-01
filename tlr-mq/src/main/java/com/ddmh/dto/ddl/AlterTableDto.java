package com.ddmh.dto.ddl;

import com.ddmh.dto.ICdcSqlMessage;
import com.ddmh.enums.CdcSqlMessageTypeEnum;
import com.ddmh.enums.ColumnTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 修改 table dto
 *
 * @author fbin
 * @version 2019/5/1 0001 19:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlterTableDto implements ICdcSqlMessage, Serializable {

    private static final long serialVersionUID = -1L;

    private String db;
    private String table;
    private String column;
    private ColumnTypeEnum columnType;
    private Integer columnLength;
    private Date timestamp;

    @Override
    public CdcSqlMessageTypeEnum getMessageType() {
        return CdcSqlMessageTypeEnum.Alter;
    }
}
