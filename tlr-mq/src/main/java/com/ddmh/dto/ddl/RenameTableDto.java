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
 * 重命名表 dto
 *
 * @author fbin
 * @version 2019/5/1 0001 21:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RenameTableDto implements ICdcSqlMessage, Serializable {

    private static final long serialVersionUID = -1L;

    private String db;
    private String table;
    private String beforeName;
    private String afterName;
    private Date timestamp;

    @Override
    public CdcSqlMessageTypeEnum getMessageType() {
        return CdcSqlMessageTypeEnum.Rename;
    }
}
