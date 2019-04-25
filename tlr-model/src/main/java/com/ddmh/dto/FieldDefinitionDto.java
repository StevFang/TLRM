package com.ddmh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FBin
 * @version 2019/4/10 13:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldDefinitionDto {

    private String fieldName;

    private Class<?> fieldType;

}
