package com.ddmh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author Fbin
 * @version 2019/4/11 7:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("SelectItemDto")
public class SelectItemDto implements Serializable {

    private String label;

    private String value;

}
