package com.ddmh.condition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fbin
 * @version 2019/4/11 8:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnQueryCondition extends BasePageCondition {

    private String dbName;

    private String tableName;

    private String searchText;

}