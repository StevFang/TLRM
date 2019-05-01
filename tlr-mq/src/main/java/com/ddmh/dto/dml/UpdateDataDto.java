package com.ddmh.dto.dml;

import com.ddmh.dto.ICdcSqlMessage;
import com.ddmh.dto.ColumnValueDto;
import com.ddmh.enums.CdcSqlMessageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 更新数据 dto
 *
 * @author fbin
 * @version 2019/5/1 0001 20:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateDataDto implements ICdcSqlMessage, Serializable {

    private static final long serialVersionUID = -1L;

    private String db;
    private String table;
    private String recordId;
    private List<ColumnValueDto> columnValueDtoList;
    private Date timestamp;

    @Override
    public CdcSqlMessageTypeEnum getMessageType() {
        return CdcSqlMessageTypeEnum.Update;
    }
}
