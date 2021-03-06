package com.ddmh.service.impl;

import com.ddmh.condition.TableQueryCondition;
import com.ddmh.mapper.TableMapper;
import com.ddmh.service.TableLoadService;
import com.ddmh.utils.PaginationUtils;
import com.ddmh.vo.TableVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * table 信息 加载 service impl
 *
 * @author Fbin
 * @version 2019/4/9 22:46
 */
@Slf4j
@Service
public class TableLoadServiceImpl implements TableLoadService {

    @Autowired
    private TableMapper tableMapper;

    @Override
    public List<TableVo> loadTableListByDbName(String dbName) {
        if(StringUtils.isNotBlank(dbName)){
            List<String> tableList = tableMapper.loadTableListByDbName(dbName);
            if(!CollectionUtils.isEmpty(tableList)){
                return convertToTableVoList(tableList);
            }
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<String> loadTableListBy(TableQueryCondition tableQueryCondition) {
        if(StringUtils.isNotBlank(tableQueryCondition.getDbName())){
            PaginationUtils.enrichMysqlPageStartAndEnd(tableQueryCondition);
            List<String> tableList = tableMapper.loadTableListBy(tableQueryCondition);
            if(!CollectionUtils.isEmpty(tableList)){
                return tableList;
            }
        }
        return Collections.EMPTY_LIST;
    }

    private List<TableVo> convertToTableVoList(List<String> tableList){
        List<TableVo> tableVoList = Lists.newArrayList();
        for(String tableName : tableList){
            TableVo tableVo = TableVo.builder().name(tableName).build();
            tableVoList.add(tableVo);
        }
        return tableVoList;
    }

}
