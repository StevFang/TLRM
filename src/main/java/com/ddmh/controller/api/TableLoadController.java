package com.ddmh.controller.api;

import com.ddmh.service.biz.TableLoadService;
import com.ddmh.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public Object loadTableList(@RequestParam("dbName") String dbName){
        List<String> tableList = tableLoadService.loadTableListByDbName(dbName);
        return JsonUtils.success(tableList);
    }

}
