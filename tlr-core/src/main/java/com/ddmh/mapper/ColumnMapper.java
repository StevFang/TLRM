package com.ddmh.mapper;

import com.ddmh.condition.ColumnCondition;
import com.ddmh.condition.ColumnQueryCondition;
import com.ddmh.dto.ColumnDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * table load mapper
 *
 * @author Fbin
 * @version 2019/4/9 22:47
 */
@Repository
public interface ColumnMapper {

    /**
     * 获取 column 总记录数
     *
     * @param columnCondition
     * @return
     */
    int loadColumnCountBy(ColumnCondition columnCondition);

    /**
     * 获取 column 分页数据
     *
     * @param columnCondition
     * @return
     */
    List<ColumnDto> loadPageColumnListBy(ColumnCondition columnCondition);

    /**
     * 根据唯一标识删除记录
     *
     * @param id
     */
    void deleteById(String id);

    /**
     * 根据唯一标识查询记录
     *
     * @param id
     * @return
     */
    ColumnDto findById(String id);

    /**
     * 新建保存
     *
     * @param columnDto
     */
    void save(ColumnDto columnDto);

    /**
     * 更新
     *
     * @param newColumnDto
     */
    void update(ColumnDto newColumnDto);

    /**
     * 模糊加载 column 列表
     *
     * @param columnQueryCondition
     * @return
     */
    List<ColumnDto> loadColumnListBy(ColumnQueryCondition columnQueryCondition);
}
