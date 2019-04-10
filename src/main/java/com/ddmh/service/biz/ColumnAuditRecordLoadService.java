package com.ddmh.service.biz;

import com.ddmh.common.Pagination;
import com.ddmh.condition.ColumnAuditRecordCondition;
import com.ddmh.vo.ColumnAuditRecordVo;

/**
 * 列变更记录加载 service interface
 *
 * @author FBin
 * @version 2019/4/10 9:28
 */
public interface ColumnAuditRecordLoadService {

    /**
     * 加载 列变更记录的分页数据
     *
     * @param columnAuditRecordCondition
     * @return
     */
    Pagination<ColumnAuditRecordVo> loadPageData(ColumnAuditRecordCondition columnAuditRecordCondition);

}
