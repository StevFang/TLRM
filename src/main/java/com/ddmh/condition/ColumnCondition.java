package com.ddmh.condition;

import lombok.*;

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
@EqualsAndHashCode(callSuper = false)
public class ColumnCondition extends AbstractCondition implements Serializable {

    private String dbName;

    private String tableName;

    private String columnName;

}
