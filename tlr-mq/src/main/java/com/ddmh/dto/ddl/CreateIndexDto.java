package com.ddmh.dto.ddl;

import com.ddmh.dto.ICdcSqlMessage;
import com.ddmh.enums.CdcSqlMessageTypeEnum;
import com.ddmh.enums.IndexTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建索引 dto
 *
 * @author fbin
 * @version 2019/5/1 0001 20:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateIndexDto implements ICdcSqlMessage, Serializable {

    private static final long serialVersionUID = -1L;

    private String db;
    private String table;
    private String indexName;
    private IndexTypeEnum indexType;
    private List<String> columns;
    private Date timestamp;

    @Override
    public CdcSqlMessageTypeEnum getMessageType() {
        return CdcSqlMessageTypeEnum.CIndex;
    }
}
