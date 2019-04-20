package com.ddmh.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fbin
 * @version 2019/4/20 13:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DbVo implements Serializable {

    private String name;

}
