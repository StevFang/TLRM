package com.ddmh.service.biz.impl;

import com.ddmh.mapper.DbMapper;
import com.ddmh.service.biz.DbLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * db load service impl
 *
 * @author FBin
 * @version 2019/4/9 18:27
 */
@Service
public class DbLoadServiceImpl implements DbLoadService {

    @Autowired
    private DbMapper dbMapper;

    @Override
    public List<String> loadDbList() {
        List<String> dbList = dbMapper.loadDbList();
        if(!CollectionUtils.isEmpty(dbList)){
            return dbList;
        }
        return Collections.EMPTY_LIST;
    }
}
