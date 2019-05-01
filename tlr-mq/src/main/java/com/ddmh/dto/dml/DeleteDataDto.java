package com.ddmh.dto.dml;

import com.ddmh.dto.ICdcSqlMessage;
import com.ddmh.enums.CdcSqlMessageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 删除数据 dto
 *
 * @author fbin
 * @version 2019/5/1 0001 20:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteDataDto implements ICdcSqlMessage, Serializable {

    private static final long serialVersionUID = -1L;

    private String db;
    private String table;
    private String recordId;
    private String column;
    private Date timestamp;

    @Override
    public CdcSqlMessageTypeEnum getMessageType() {
        return CdcSqlMessageTypeEnum.Delete;
    }
}
