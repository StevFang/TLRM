package com.ddmh.controller;

import com.ddmh.service.biz.ColumnModifyService;
import com.ddmh.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 列删除
 *
 * @author Fbin
 * @version 2019/4/10 8:03
 */
@RestController
@RequestMapping("/column")
public class ColumnDeleteController {

    @Autowired
    private ColumnModifyService columnModifyService;

    @PostMapping("/delete")
    public Object addColumn(String id){
        String checkResult = checkParams(id);
        if(StringUtils.isNotBlank(checkResult)){
            return JsonUtils.error(checkResult);
        }
        columnModifyService.deleteById(id);
        return JsonUtils.success();
    }

    private String checkParams(String id) {
        return StringUtils.isNotBlank(id) ? null : "id不能为空！";
    }

}
