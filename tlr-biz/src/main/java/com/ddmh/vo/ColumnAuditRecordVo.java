package com.ddmh.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 列变更记录 view object
 *
 * @author FBin
 * @version 2019/4/10 9:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnAuditRecordVo implements Serializable {

    private String id;

    private String columnId;

    private String updateMeta;

    private String before;

    private String after;

    private String updateSql;

    private String createOn;

}
