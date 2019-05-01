package com.ddmh.dto.ddl;

import com.ddmh.dto.ICdcSqlMessage;
import com.ddmh.enums.CdcSqlMessageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 删除 table dto
 *
 * @author fbin
 * @version 2019/5/1 0001 19:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DropTableDto implements ICdcSqlMessage, Serializable {

    private static final long serialVersionUID = -1L;

    private String db;
    private String table;
    private Date timestamp;

    @Override
    public CdcSqlMessageTypeEnum getMessageType() {
        return CdcSqlMessageTypeEnum.Drop;
    }
}
