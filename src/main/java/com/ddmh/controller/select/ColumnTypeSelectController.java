package com.ddmh.controller.select;

import com.ddmh.dto.SelectItemDto;
import com.ddmh.enums.ColumnTypeEnum;
import com.ddmh.utils.JsonUtils;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Fbin
 * @version 2019/4/11 7:25
 */
@RestController
@RequestMapping("/select")
public class ColumnTypeSelectController {

    @PostMapping("/columnType")
    public Object loadColumnTypeData(){
        List<SelectItemDto> columnTypeList = getColumnTypeList();
        return JsonUtils.success(columnTypeList);
    }

    private List<SelectItemDto> getColumnTypeList() {
        List<SelectItemDto> selectItemDtoList = Lists.newArrayList();
        for(ColumnTypeEnum columnTypeEnum : ColumnTypeEnum.values()){
            SelectItemDto selectItemDto =
                    SelectItemDto.builder()
                            .label(columnTypeEnum.getLabel())
                            .value(columnTypeEnum.getValue())
                            .build();
            selectItemDtoList.add(selectItemDto);
        }
        return selectItemDtoList;
    }

}
