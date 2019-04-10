package com.ddmh.service.biz;

import com.ddmh.vo.ColumnVo;

/**
 * 字段变更 service interface
 *
 * @author FBin
 * @version 2019/4/10 9:06
 */
public interface ColumnModifyService {

    /**
     * 新增
     *
     * @param columnVo
     */
    void create(ColumnVo columnVo);

    /**
     * 更新
     *
     * @param columnVo
     */
    void update(ColumnVo columnVo);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);

}
