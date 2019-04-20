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
public class ResponseVo implements Serializable {

    private int code;

    private String url;

    @Builder.Default
    private String msg = "操作成功";

    private Object data;

}
