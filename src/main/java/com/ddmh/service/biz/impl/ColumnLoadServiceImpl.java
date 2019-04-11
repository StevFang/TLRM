package com.ddmh.service.biz.impl;

import com.ddmh.common.Pagination;
import com.ddmh.condition.ColumnCondition;
import com.ddmh.condition.ColumnQueryCondition;
import com.ddmh.dto.ColumnDto;
import com.ddmh.enums.ColumnTypeEnum;
import com.ddmh.enums.FlagEnum;
import com.ddmh.enums.IndexTypeEnum;
import com.ddmh.mapper.ColumnMapper;
import com.ddmh.service.biz.ColumnLoadService;
import com.ddmh.utils.PaginationUtils;
import com.ddmh.vo.ColumnVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * column load service impl
 *
 * @author Fbin
 * @version 2019/4/10 7:14
 */
@Slf4j
@Service
public class ColumnLoadServiceImpl implements ColumnLoadService {

    @Autowired
    private ColumnMapper columnMapper;

    @Override
    public Pagination<ColumnVo> loadColumnPageData(ColumnCondition columnCondition) {
        int count = columnMapper.loadColumnCountBy(columnCondition);

        List<ColumnVo> columnVoList = Lists.newArrayList();
        if(count > 0){
            PaginationUtils.enrichMysqlPageStartAndEnd(columnCondition);

            List<ColumnDto> columnDtoList = columnMapper.loadPageColumnListBy(columnCondition);
            // convert and enrich
            columnDtoList.forEach(columnDto -> columnVoList.add(convertDtoToVo(columnDto)));
        }

        int pages = PaginationUtils.getPages(count, columnCondition.getPageSize());

        return Pagination.<ColumnVo>builder().current(columnCondition.getCurrent())
                .pageSize(columnCondition.getPageSize())
                .total(count)
                .pages(pages)
                .pageList(columnVoList)
                .build();
    }

    @Override
    public List<ColumnVo> loadColumnListBy(ColumnQueryCondition columnQueryCondition) {
        List<ColumnDto> columnDtoList = columnMapper.loadColumnListBy(columnQueryCondition);
        return null;
    }

    /**
     * dto convert to vo
     *
     * @param columnDto
     * @return
     */
    private ColumnVo convertDtoToVo(ColumnDto columnDto) {
        ColumnTypeEnum columnTypeEnum = ColumnTypeEnum.getByValue(columnDto.getColumnType());
        FlagEnum indexFlag = FlagEnum.getByValue(columnDto.getIndexFlag());
        IndexTypeEnum indexTypeEnum = IndexTypeEnum.getByValue(columnDto.getIndexType());
        FlagEnum nullAble = FlagEnum.getByValue(columnDto.getNullAble());
        FlagEnum primaryKeyFlag = FlagEnum.getByValue(columnDto.getPrimaryKeyFlag());
        FlagEnum requiredFlag = FlagEnum.getByValue(columnDto.getRequireFlag());

        return ColumnVo.builder()
                .id(columnDto.getId())
                .dbName(columnDto.getDbName())
                .tableName(columnDto.getTableName())
                .columnName(columnDto.getColumnName())
                .columnDesc(columnDto.getColumnDesc())
                .columnLength(columnDto.getColumnLength())
                .columnType(columnDto.getColumnType())
                .columnTypeTitle(columnTypeEnum != null ? columnTypeEnum.getLabel() : "")
                .indexFlag(indexFlag != null ? indexFlag.getLabel() : "")
                .indexType(indexTypeEnum != null ? indexTypeEnum.getLabel() : "")
                .indexDesc(columnDto.getIndexDesc())
                .mappingType(columnDto.getMappingType())
                .nullAble(nullAble != null ? nullAble.getLabel() : "")
                .primaryKeyFlag(primaryKeyFlag != null ? primaryKeyFlag.getLabel() : "")
                .requireFlag(requiredFlag != null ? requiredFlag.getLabel() : "")
                .relatedTable(columnDto.getRelatedTable())
                .relatedTableField(columnDto.getRelatedTableField()).build();
    }
}
