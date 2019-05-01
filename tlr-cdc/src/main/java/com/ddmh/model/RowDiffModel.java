package com.ddmh.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * mysql bin-log data
 *
 * @author fbin
 * @version 2019/4/27 0027 17:46
 */
@Data
@Builder
public class RowDiffModel {

    private long timestamp;

    private String tableName;

    /**
     * 主键列
     */
    private List<String> pkColumnName;

    private List<Object> pk;

    /**
     * 1 新建 2 更新 3 删除
     */
    private int type;

    private List<String> diffColumns;

    private Map<String, Object> preValue;

    private Map<String, Object> newValue;

}
