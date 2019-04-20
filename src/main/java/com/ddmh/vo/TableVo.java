package com.ddmh.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fbin
 * @version 2019/4/20 14:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TableVo implements Serializable {

    private String name;

}
