package com.ddmh.controller;

import com.ddmh.common.Pagination;
import com.ddmh.condition.ColumnCondition;
import com.ddmh.service.biz.ColumnLoadService;
import com.ddmh.utils.JsonUtils;
import com.ddmh.vo.ColumnVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 表列定义列表加载
 *
 * @author Fbin
 * @version 2019/4/9 22:43
 */
@RestController
@RequestMapping("/column")
public class ColumnLoadController extends AbstractController{

    @Autowired
    private ColumnLoadService columnLoadService;

    @PostMapping("/list")
    public Object loadColumnList(@RequestBody ColumnCondition columnCondition){
        String checkResult = checkParams(columnCondition);
        if(StringUtils.isNotBlank(checkResult)){
            return JsonUtils.error(checkResult);
        }
        Pagination<ColumnVo> columnPageData = columnLoadService.loadColumnPageData(columnCondition);
        return JsonUtils.parse(columnPageData);
    }

    private String checkParams(ColumnCondition columnCondition) {
        if(StringUtils.isBlank(columnCondition.getDbName())){
            return "未获取到dbName数据！";
        }

        if(StringUtils.isBlank(columnCondition.getTableName())){
            return "未获取到tableName数据！";
        }

        if(StringUtils.isBlank(columnCondition.getSortName())){
            columnCondition.setSortName("column_name");
        }

        if(StringUtils.isBlank(columnCondition.getOrder())){
            columnCondition.setOrder("asc");
        }

        return super.checkParams(columnCondition);
    }

}
