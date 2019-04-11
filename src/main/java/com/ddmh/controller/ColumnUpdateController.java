package com.ddmh.controller;

import com.ddmh.service.biz.ColumnModifyService;
import com.ddmh.utils.JsonUtils;
import com.ddmh.vo.ColumnVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 列更新
 *
 * @author Fbin
 * @version 2019/4/10 8:02
 */
@RestController
@RequestMapping("/column")
public class ColumnUpdateController {

    @Autowired
    private ColumnModifyService columnModifyService;

    @PostMapping("/update")
    public Object addColumn(ColumnVo columnVo){
        String checkResult = checkParams(columnVo);
        if(StringUtils.isNotBlank(checkResult)){
            return JsonUtils.error(checkResult);
        }
        columnModifyService.update(columnVo);
        return JsonUtils.success();
    }

    private String checkParams(ColumnVo columnVo) {

        return null;
    }


}
