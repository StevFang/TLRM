package com.ddmh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author FBin
 * @version 2019/4/10 13:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("FieldDefinitionDto")
public class FieldDefinitionDto {

    private String fieldName;

    private Class<?> fieldType;

}
