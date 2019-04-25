package com.ddmh.condition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author Fbin
 * @version 2019/4/11 7:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("TableQueryCondition")
public class TableQueryCondition extends BasePageCondition {

    private String dbName;

    private String searchText;

    private String selectedTableName;

}
