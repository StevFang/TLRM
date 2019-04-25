package com.ddmh.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Fbin
 * @version 2019/4/9 23:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination<T> implements Serializable {

    private Integer current;

    private Integer pageSize;

    private Integer pages;

    private Integer total;

    private List<T> pageList;

}
