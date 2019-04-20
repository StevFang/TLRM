package com.ddmh.exceptions;

import com.ddmh.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Fbin
 * @version 2019/4/20 14:07
 */
@Slf4j
@ControllerAdvice
public class TlrExceptionHandler {

    @ResponseBody
    @ExceptionHandler(TlrException.class)
    public ResponseVo handleTlrException(TlrException e){
        log.error(e.getMsg(), e);
        return ResponseVo.builder().code(-1).msg(e.getMsg()).build();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseVo handleException(Exception e){
        log.error(e.getMessage(), e);
        return ResponseVo.builder().code(-1).msg("系统异常").build();
    }

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public ResponseVo handleNotRunTimeException(Throwable e){
        log.error(e.getMessage(), e);
        return ResponseVo.builder().code(-1).msg("未知异常").build();
    }

}
