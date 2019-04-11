package com.ddmh.controller.api;

import com.ddmh.dto.SelectItemDto;
import com.ddmh.enums.IndexTypeEnum;
import com.ddmh.utils.JsonUtils;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Fbin
 * @version 2019/4/11 7:35
 */
@RestController
@RequestMapping("/select")
public class IndexTypeSelectController {

    @PostMapping("/indexType")
    public Object loadIndexTypeData(){
        List<SelectItemDto> selectItemDtoList = getSelectItemDtoList();
        return JsonUtils.success(selectItemDtoList);
    }

    private List<SelectItemDto> getSelectItemDtoList() {
        List<SelectItemDto> selectItemDtoList = Lists.newArrayList();
        for(IndexTypeEnum indexTypeEnum : IndexTypeEnum.values()){
            SelectItemDto selectItemDto =
                    SelectItemDto.builder()
                            .label(indexTypeEnum.getLabel())
                            .value(indexTypeEnum.getValue())
                            .build();
            selectItemDtoList.add(selectItemDto);
        }
        return selectItemDtoList;
    }

}
