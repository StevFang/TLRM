package com.ddmh.condition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fbin
 * @version 2019/4/11 7:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TableQueryCondition extends BasePageCondition {

    private String dbName;

    private String searchText;

    private String selectedTableName;

}
