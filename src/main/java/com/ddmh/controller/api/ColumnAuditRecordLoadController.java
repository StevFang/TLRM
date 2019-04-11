package com.ddmh.controller.api;

import com.ddmh.common.Pagination;
import com.ddmh.condition.ColumnAuditRecordCondition;
import com.ddmh.service.biz.ColumnAuditRecordLoadService;
import com.ddmh.utils.JsonUtils;
import com.ddmh.vo.ColumnAuditRecordVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 列变更记录
 *
 * @author FBin
 * @version 2019/4/10 9:25
 */
@Slf4j
@RestController
@RequestMapping("/column/audit/record")
public class ColumnAuditRecordLoadController extends AbstractController{

    @Autowired
    private ColumnAuditRecordLoadService columnAuditRecordLoadService;

    @PostMapping("/list")
    public Object loadColumnAuditRecordList(@RequestBody ColumnAuditRecordCondition columnAuditRecordCondition){
        String checkResult = checkParams(columnAuditRecordCondition);
        if(StringUtils.isNotBlank(checkResult)){
            return JsonUtils.error(checkResult);
        }
        Pagination<ColumnAuditRecordVo> pageData = columnAuditRecordLoadService.loadPageData(columnAuditRecordCondition);
        return JsonUtils.success(pageData);
    }

    private String checkParams(ColumnAuditRecordCondition columnAuditRecordCondition) {
        String columnId = columnAuditRecordCondition.getColumnId();
        if(StringUtils.isBlank(columnId)){
            return "columnId字段的值不能为空！";
        }

        return super.checkParams(columnAuditRecordCondition);
    }
}
