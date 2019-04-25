package com.ddmh.controller.api;

import com.ddmh.controller.AbstractApiController;
import com.ddmh.service.ColumnLoadService;
import com.ddmh.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库列表加载
 *
 * @author FBin
 * @version 2019/4/9 18:24
 */
@RestController
@RequestMapping("/column")
public class ColumnDetailController extends AbstractApiController {

    @Autowired
    private ColumnLoadService columnLoadService;

    @GetMapping("/detail/{id}")
    public ResponseVo loadDetail(@PathVariable(value = "id", required = false) String id){
        String checkResultStr = checkParams(id);
        return StringUtils.isNotBlank(checkResultStr)
                ? sendFail(checkResultStr)
                : sendSuccess(columnLoadService.loadDetailBy(id));
    }

    private String checkParams(String id) {
        if(StringUtils.isBlank(id)){
            return "参数id不能为空！";
        }
        return null;
    }

}
