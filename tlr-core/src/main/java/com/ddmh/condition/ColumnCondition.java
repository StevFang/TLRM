package com.ddmh.condition;

import lombok.*;
import org.apache.ibatis.type.Alias;

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
@Alias("ColumnCondition")
public class ColumnCondition extends BasePageCondition implements Serializable {

    private String dbName;

    private String tableName;

    private String columnName;

}
