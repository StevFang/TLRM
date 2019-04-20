package com.ddmh.controller.api;

import com.ddmh.controller.AbstractApiController;
import com.ddmh.service.biz.TableLoadService;
import com.ddmh.vo.ResponseVo;
import com.ddmh.vo.TableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Fbin
 * @version 2019/4/9 22:43
 */
@RestController
@RequestMapping("/table")
public class TableListController extends AbstractApiController {

    @Autowired
    private TableLoadService tableLoadService;

    @GetMapping("/list")
    public ResponseVo loadTableList(@RequestParam("dbName") String dbName){
        List<TableVo> tableList = tableLoadService.loadTableListByDbName(dbName);
        return sendSuccess(tableList);
    }

}
