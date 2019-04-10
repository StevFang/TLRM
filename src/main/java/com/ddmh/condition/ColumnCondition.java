package com.ddmh.condition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * column condition
 *
 * @author Fbin
 * @version 2019/4/9 23:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnCondition extends AbstractCondition implements Serializable {

    private String dbName;

    private String tableName;

    private String columnName;

}
