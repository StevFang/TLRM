package com.ddmh.controller;

import com.ddmh.service.biz.ColumnModifyService;
import com.ddmh.utils.JsonUtils;
import com.ddmh.vo.ColumnVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 列新增
 *
 * @author Fbin
 * @version 2019/4/10 8:02
 */
@RestController
@RequestMapping("/column")
public class ColumnAddController {

    @Autowired
    private ColumnModifyService columnModifyService;

    @PostMapping("/add")
    public Object addColumn(@RequestBody ColumnVo columnVo){
        String checkResult = checkParams(columnVo);
        if(StringUtils.isNotBlank(checkResult)){
            return JsonUtils.error(checkResult);
        }
        columnModifyService.create(columnVo);
        return JsonUtils.success();
    }

    private String checkParams(ColumnVo columnVo) {

        return null;
    }

}
