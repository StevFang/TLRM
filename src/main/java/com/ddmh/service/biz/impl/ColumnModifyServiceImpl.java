package com.ddmh.service.biz.impl;

import com.ddmh.mapper.ColumnMapper;
import com.ddmh.service.biz.ColumnModifyService;
import com.ddmh.vo.ColumnVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 字段变更 service interface
 *
 * @author FBin
 * @version 2019/4/10 9:06
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ColumnModifyServiceImpl implements ColumnModifyService {

    @Autowired
    private ColumnMapper columnMapper;

    @Override
    public void create(ColumnVo columnVo) {
        
    }

    @Override
    public void update(ColumnVo columnVo) {

    }

    @Override
    public void deleteById(String id) {
        columnMapper.deleteById(id);
    }
}
