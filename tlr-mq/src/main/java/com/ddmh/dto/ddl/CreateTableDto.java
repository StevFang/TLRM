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
 * 创建 table dto
 *
 * @author fbin
 * @version 2019/5/1 0001 19:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTableDto implements ICdcSqlMessage, Serializable {

    private static final long serialVersionUID = -1L;

    private String db;
    private String table;
    private Date timestamp;

    @Override
    public CdcSqlMessageTypeEnum getMessageType() {
        return CdcSqlMessageTypeEnum.Create;
    }
}
