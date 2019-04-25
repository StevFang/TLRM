package com.ddmh.constant;

import com.ddmh.dto.ColumnDto;
import com.ddmh.dto.FieldDefinitionDto;
import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author FBin
 * @version 2019/4/10 13:21
 */
public class FieldDefinitionConstant {

    private static List<FieldDefinitionDto> columnDtoFieldDefinitionDtoList = Lists.newArrayList();

    static {
        Field[] fields = ColumnDto.class.getDeclaredFields();
        for(Field field : fields){
            columnDtoFieldDefinitionDtoList.add(FieldDefinitionDto.builder().fieldName(field.getName()).fieldType(field.getType()).build());
        }
    }

    public static List<FieldDefinitionDto> getColumnDtoFieldDefinitionDtoList(){
        return columnDtoFieldDefinitionDtoList;
    }

}
