package com.ddmh.service.biz.impl;

import com.ddmh.mapper.TableMapper;
import com.ddmh.service.biz.TableLoadService;
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
    public List<String> loadTableListByDbName(String dbName) {
        if(StringUtils.isNotBlank(dbName)){
            List<String> tableList = tableMapper.loadTableListByDbName(dbName);
            if(!CollectionUtils.isEmpty(tableList)){
                return tableList;
            }
        }
        return Collections.EMPTY_LIST;
    }

}
