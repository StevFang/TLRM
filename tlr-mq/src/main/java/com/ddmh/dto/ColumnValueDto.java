package com.ddmh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 字段变更dto
 *
 * @author fbin
 * @version 2019/5/1 0001 22:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnValueDto implements Serializable {

    private String column;
    private String before;
    private String after;

}
