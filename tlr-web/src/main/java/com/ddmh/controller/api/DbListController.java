package com.ddmh.controller.api;

import com.ddmh.controller.AbstractApiController;
import com.ddmh.service.DbLoadService;
import com.ddmh.vo.DbVo;
import com.ddmh.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据库列表加载
 *
 * @author FBin
 * @version 2019/4/9 18:24
 */
@RestController
@RequestMapping("/db")
public class DbListController extends AbstractApiController {

    @Autowired
    private DbLoadService dbLoadService;

    @GetMapping("/list")
    public ResponseVo loadDbList(){
        List<DbVo> dbList = dbLoadService.loadDbList();
        return sendSuccess(dbList);
    }

}
