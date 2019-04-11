package com.ddmh.service.biz.impl;

import com.ddmh.common.Pagination;
import com.ddmh.condition.ColumnAuditRecordCondition;
import com.ddmh.dto.ColumnAuditRecordDto;
import com.ddmh.mapper.ColumnAuditRecordMapper;
import com.ddmh.service.biz.ColumnAuditRecordLoadService;
import com.ddmh.utils.DateUtils;
import com.ddmh.utils.PaginationUtils;
import com.ddmh.vo.ColumnAuditRecordVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 列变更记录加载service impl
 *
 * @author FBin
 * @version 2019/4/10 9:37
 */
@Slf4j
@Service
public class ColumnAuditRecordLoadServiceImpl implements ColumnAuditRecordLoadService {

    @Autowired
    private ColumnAuditRecordMapper columnAuditRecordMapper;

    @Override
    public Pagination<ColumnAuditRecordVo> loadPageData(ColumnAuditRecordCondition columnAuditRecordCondition) {
        int count = columnAuditRecordMapper.loadCountBy(columnAuditRecordCondition);

        List<ColumnAuditRecordVo> columnAuditRecordVoList = Lists.newArrayList();
        if(count > 0){
            PaginationUtils.enrichMysqlPageStartAndEnd(columnAuditRecordCondition);

            List<ColumnAuditRecordDto> columnAuditRecordDtoList = columnAuditRecordMapper.loadPageListBy(columnAuditRecordCondition);
            // convert and enrich
            columnAuditRecordDtoList.forEach(columnAuditRecordDto -> columnAuditRecordVoList.add(convertDtoToVo(columnAuditRecordDto)));
        }

        int pages = PaginationUtils.getPages(count, columnAuditRecordCondition.getPageSize());

        return Pagination.<ColumnAuditRecordVo>builder().current(columnAuditRecordCondition.getCurrent())
                .pageSize(columnAuditRecordCondition.getPageSize())
                .total(count)
                .pages(pages)
                .pageList(columnAuditRecordVoList)
                .build();
    }

    private ColumnAuditRecordVo convertDtoToVo(ColumnAuditRecordDto columnAuditRecordDto) {
        String createOn = DateUtils.format(columnAuditRecordDto.getCreateOn(), DateUtils.Pattern.PATTERN_DATETIME_1);
        return ColumnAuditRecordVo.builder()
                .id(columnAuditRecordDto.getId())
                .columnId(columnAuditRecordDto.getColumnId())
                .updateMeta(columnAuditRecordDto.getUpdateMeta())
                .before(columnAuditRecordDto.getBefore())
                .after(columnAuditRecordDto.getAfter())
                .updateSql(columnAuditRecordDto.getUpdateSql())
                .createOn(createOn).build();
    }
}
