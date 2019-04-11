package com.ddmh.controller.api;

import com.ddmh.condition.AbstractCondition;

/**
 * @author FBin
 * @version 2019/4/10 9:55
 */
public abstract class AbstractController {

    /**
     * 基本参数条件校验
     *
     * @param abstractCondition
     * @return
     */
    protected String checkParams(AbstractCondition abstractCondition){
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

}
