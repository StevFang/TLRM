package com.ddmh.controller.api;

import com.ddmh.condition.ColumnQueryCondition;
import com.ddmh.dto.SelectItemDto;
import com.ddmh.service.ColumnLoadService;
import com.ddmh.utils.JsonUtils;
import com.ddmh.vo.ColumnVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fbin
 * @version 2019/4/11 7:39
 */
@RestController
@RequestMapping("/select")
public class ColumnSelectController {

    @Autowired
    private ColumnLoadService columnLoadService;

    @GetMapping("/column")
    public Object loadTableData(ColumnQueryCondition columnQueryCondition){
        enrichColumnQueryCondition(columnQueryCondition);

        List<SelectItemDto> selectItemDtoList = Lists.newArrayList();

        List<ColumnVo> columnVoList = columnLoadService.loadColumnListBy(columnQueryCondition);
        if(!CollectionUtils.isEmpty(columnVoList)){
            getColumnList(columnVoList, selectItemDtoList);
        }
        return JsonUtils.success(selectItemDtoList);
    }

    private void enrichColumnQueryCondition(ColumnQueryCondition columnQueryCondition) {
        columnQueryCondition.setCurrent(1);
        columnQueryCondition.setPageSize(20);
        columnQueryCondition.setSortName("column_name");
        columnQueryCondition.setOrder("asc");
    }

    private void getColumnList(List<ColumnVo> columnVoList,
                               List<SelectItemDto> selectItemDtoList) {

        for(ColumnVo columnVo : columnVoList){
            SelectItemDto selectItemDto =
                    SelectItemDto.builder()
                            .label(columnVo.getColumnName())
                            .value(columnVo.getId())
                            .build();
            selectItemDtoList.add(selectItemDto);
        }
    }

}
