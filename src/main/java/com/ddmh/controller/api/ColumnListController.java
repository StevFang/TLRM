package com.ddmh.controller.api;

import com.ddmh.common.Pagination;
import com.ddmh.condition.ColumnCondition;
import com.ddmh.controller.AbstractApiController;
import com.ddmh.service.biz.ColumnLoadService;
import com.ddmh.vo.ColumnVo;
import com.ddmh.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 表列定义列表加载
 *
 * @author Fbin
 * @version 2019/4/9 22:43
 */
@RestController
@RequestMapping("/column")
public class ColumnListController extends AbstractApiController {

    @Autowired
    private ColumnLoadService columnLoadService;

    @GetMapping("/list")
    public ResponseVo loadColumnList(ColumnCondition columnCondition){
        String checkResult = checkParams(columnCondition);
        if(StringUtils.isNotBlank(checkResult)){
            return sendFail(checkResult);
        }
        Pagination<ColumnVo> columnPageData = columnLoadService.loadColumnPageData(columnCondition);
        return sendSuccess(columnPageData);
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

        return super.checkPageParams(columnCondition);
    }

}
