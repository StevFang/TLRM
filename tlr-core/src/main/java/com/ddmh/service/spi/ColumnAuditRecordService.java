package com.ddmh.service.spi;

import com.ddmh.dto.ColumnAuditRecordDto;

import java.util.List;

/**
 * 列变更记录 spi interface
 *
 * @author FBin
 * @version 2019/4/10 11:50
 */
public interface ColumnAuditRecordService {

    /**
     * 新增
     *
     * @param columnAuditRecordDto
     */
    void save(ColumnAuditRecordDto columnAuditRecordDto);

    /**
     * 批量新增
     *
     * @param columnAuditRecordDtoList
     */
    void batchSave(List<ColumnAuditRecordDto> columnAuditRecordDtoList);

}
