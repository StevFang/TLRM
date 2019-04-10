package com.ddmh.controller;

import com.ddmh.common.Pagination;
import com.ddmh.condition.ColumnCondition;
import com.ddmh.service.ColumnLoadService;
import com.ddmh.service.TableLoadService;
import com.ddmh.utils.JsonUtils;
import com.ddmh.vo.ColumnVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 表字段定义列表加载
 *
 * @author Fbin
 * @version 2019/4/9 22:43
 */
@RestController
@RequestMapping("/column")
public class ColumnLoadController {

    @Autowired
    private ColumnLoadService tableLoadService;

    @PostMapping("/list")
    public Object loadColumnList(ColumnCondition columnCondition){
        String checkResult = checkParams(columnCondition);
        if(StringUtils.isNotBlank(checkResult)){
            return JsonUtils.error(checkResult);
        }
        Pagination<ColumnVo> columnPageData = tableLoadService.loadColumnPageData(columnCondition);
        return JsonUtils.parse(columnPageData);
    }

    private String checkParams(ColumnCondition columnCondition) {
        if(StringUtils.isBlank(columnCondition.getDbName())){
            return "未获取到dbName数据！";
        }

        if(StringUtils.isBlank(columnCondition.getTableName())){
            return "未获取到tableName数据！";
        }

        Integer current = columnCondition.getCurrent();
        if(current == null){
            return "当前页不能为空！";
        }
        if(current < 0){
            return "当前页不能为负值！";
        }

        Integer pageSize = columnCondition.getPageSize();
        if(pageSize == null){
            return "每页记录数不能为空！";
        }
        if(pageSize < 0){
            return "每页记录数不能为负值！";
        }

        return null;
    }

}
