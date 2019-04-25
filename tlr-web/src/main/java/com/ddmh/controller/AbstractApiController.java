package com.ddmh.controller;

import com.ddmh.condition.BasePageCondition;
import com.ddmh.vo.ResponseVo;

/**
 * @author FBin
 * @version 2019/4/10 9:55
 */
public abstract class AbstractApiController {

    /**
     * 基本参数条件校验
     *
     * @param abstractCondition
     * @return
     */
    protected String checkPageParams(BasePageCondition abstractCondition){
        Integer current = abstractCondition.getCurrent();
        if(current == null){
            return "当前页不能为空！";
        }
        if(current < 1){
            return "当前页不能为小于1的数！";
        }

        Integer pageSize = abstractCondition.getPageSize();
        if(pageSize == null){
            return "每页记录数不能为空！";
        }
        if(pageSize < 0){
            return "每页记录数不能为负值！";
        }

        return null;
    }

    protected ResponseVo sendSuccess(Object data){
        return ResponseVo.builder().code(0).data(data).build();
    }

    protected ResponseVo sendSuccess(String msg, Object data){
        ResponseVo responseVo = sendSuccess(data);
        responseVo.setMsg(msg);
        return responseVo;
    }

    protected ResponseVo sendSuccess(String url, String msg, Object data){
        ResponseVo responseVo = sendSuccess(msg, data);
        responseVo.setUrl(url);
        return responseVo;
    }

    protected ResponseVo sendFail(String msg){
        return ResponseVo.builder().code(-1).msg(msg).build();
    }

    protected ResponseVo sendFail(String url, String msg){
        ResponseVo responseVo = sendFail(msg);
        responseVo.setUrl(url);
        return responseVo;
    }
}
