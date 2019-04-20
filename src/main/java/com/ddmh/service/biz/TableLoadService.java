package com.ddmh.service.biz;

import com.ddmh.condition.TableQueryCondition;
import com.ddmh.vo.TableVo;

import java.util.List;

/**
 * 加载 table 信息
 *
 * @author Fbin
 * @version 2019/4/9 22:44
 */
public interface TableLoadService {

    /**
     * 加载db下的table列表
     *
     * @param dbName 数据库名
     * @return
     */
    List<TableVo> loadTableListByDbName(String dbName);

    /**
     * 模糊查询db下的table列表
     *
     * @param tableQueryCondition
     * @return
     */
    List<String> loadTableListBy(TableQueryCondition tableQueryCondition);

}
