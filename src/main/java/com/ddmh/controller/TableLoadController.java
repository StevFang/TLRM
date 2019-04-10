package com.ddmh.controller;

import com.ddmh.service.TableLoadService;
import com.ddmh.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Fbin
 * @version 2019/4/9 22:43
 */
@RestController
@RequestMapping("/table")
public class TableLoadController {

    @Autowired
    private TableLoadService tableLoadService;

    @PostMapping("/list")
    public Object loadTableList(String dbName){
        List<String> tableList = tableLoadService.loadTableListByDbName(dbName);
        return JsonUtils.success(tableList);
    }

}
