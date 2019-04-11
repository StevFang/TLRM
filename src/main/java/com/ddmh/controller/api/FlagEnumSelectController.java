package com.ddmh.controller.api;

import com.ddmh.dto.SelectItemDto;
import com.ddmh.enums.FlagEnum;
import com.ddmh.utils.JsonUtils;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Fbin
 * @version 2019/4/11 7:32
 */
@RestController
@RequestMapping("/select")
public class FlagEnumSelectController {

    @PostMapping("/flagEnum")
    public Object loadFlagEnumData(){
        List<SelectItemDto> flagEnumList = getFlagEnumList();
        return JsonUtils.success(flagEnumList);
    }

    private List<SelectItemDto> getFlagEnumList() {
        List<SelectItemDto> selectItemDtoList = Lists.newArrayList();
        for(FlagEnum flagEnum : FlagEnum.values()){
            SelectItemDto selectItemDto =
                    SelectItemDto.builder()
                            .label(flagEnum.getLabel())
                            .value(flagEnum.getValue())
                            .build();
            selectItemDtoList.add(selectItemDto);
        }
        return selectItemDtoList;
    }

}
