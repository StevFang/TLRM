package com.ddmh.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * column view object
 *
 * @author Fbin
 * @version 2019/4/9 23:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnVo implements Serializable {

    private String id;

    private String dbName;

    private String tableName;

    private String columnName;

    private String columnType;

    private String columnTypeTitle;

    private String columnLength;

    private String mappingType;

    private String columnDesc;

    private String requireFlag;

    private String nullAble;

    private String primaryKeyFlag;

    private String indexFlag;

    private String indexType;

    private String indexDesc;

    private String relatedTable;

    private String relatedTableField;

}
