package com.ddmh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * column dto
 *
 * @author Fbin
 * @version 2019/4/9 23:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("ColumnDto")
public class ColumnDto implements Serializable {

    private String id;

    private String dbName;

    private String tableName;

    private String columnName;

    private String columnType;

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
