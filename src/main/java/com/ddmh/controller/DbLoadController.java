package com.ddmh.controller;

import com.ddmh.service.DbLoadService;
import com.ddmh.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
public class DbLoadController {

    @Autowired
    private DbLoadService dbLoadService;

    @PostMapping("/list")
    public Object loadDbList(){
        List<String> dbList = dbLoadService.loadDbList();
        return JsonUtils.success(dbList);
    }

}
