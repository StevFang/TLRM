package com.ddmh.mapper;

import com.ddmh.condition.TableQueryCondition;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * table load mapper
 *
 * @author Fbin
 * @version 2019/4/9 22:47
 */
@Repository
public interface TableMapper {

    /**
     * 获取 table 列表
     *
     * @param dbName
     * @return
     */
    List<String> loadTableListByDbName(String dbName);

    /**
     * 模糊加载 table 列表
     *
     * @param tableQueryCondition
     * @return
     */
    List<String> loadTableListBy(TableQueryCondition tableQueryCondition);
}
