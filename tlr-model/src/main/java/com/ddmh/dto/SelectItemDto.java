package com.ddmh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fbin
 * @version 2019/4/11 7:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectItemDto implements Serializable {

    private String label;

    private String value;

}
