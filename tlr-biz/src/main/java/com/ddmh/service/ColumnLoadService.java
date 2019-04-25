package com.ddmh.service;

import com.ddmh.common.Pagination;
import com.ddmh.condition.ColumnCondition;
import com.ddmh.condition.ColumnQueryCondition;
import com.ddmh.vo.ColumnVo;

import java.util.List;

/**
 * 加载 column 信息
 *
 * @author Fbin
 * @version 2019/4/9 22:44
 */
public interface ColumnLoadService {

    /**
     * 加载 字段 分页数据
     *
     * @param columnCondition
     * @return
     */
    Pagination<ColumnVo> loadColumnPageData(ColumnCondition columnCondition);

    /**
     * 模糊查询 db table 下的 column 列表
     *
     * @param columnQueryCondition
     * @return
     */
    List<ColumnVo> loadColumnListBy(ColumnQueryCondition columnQueryCondition);

    /**
     * 根据id获取字段的详细信息
     *
     * @param id
     * @return
     */
    ColumnVo loadDetailBy(String id);
}
