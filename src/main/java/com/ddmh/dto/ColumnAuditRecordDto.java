package com.ddmh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 列变更记录dto
 *
 * @author FBin
 * @version 2019/4/10 9:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnAuditRecordDto implements Serializable {

    private String id;

    private String columnId;

    private String updateMeta;

    private String before;

    private String after;

    private String updateSql;

    private Date createOn;

}
