package com.ddmh.condition;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * column condition
 *
 * @author Fbin
 * @version 2019/4/9 23:03
 */
@Data
@Alias("BasePageCondition")
public class BasePageCondition implements Serializable {

    private Integer current;

    private Integer pageSize;

    private String sortName;

    private String order;

    private Integer start;

    private Integer end;

}
