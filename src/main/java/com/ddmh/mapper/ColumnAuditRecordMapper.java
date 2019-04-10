package com.ddmh.mapper;

import com.ddmh.condition.ColumnAuditRecordCondition;
import com.ddmh.dto.ColumnAuditRecordDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 列变更记录 mapper
 *
 * @author FBin
 * @version 2019/4/10 9:38
 */
@Repository
public interface ColumnAuditRecordMapper {

    /**
     * 加载列变更记录总数
     *
     * @param columnAuditRecordCondition
     * @return
     */
    int loadCountBy(ColumnAuditRecordCondition columnAuditRecordCondition);

    /**
     * 加载列变更记录列表
     *
     * @param columnAuditRecordCondition
     * @return
     */
    List<ColumnAuditRecordDto> loadPageListBy(ColumnAuditRecordCondition columnAuditRecordCondition);
}
