package com.ddmh.service.spi.impl;

import com.ddmh.mapper.ColumnAuditRecordMapper;
import com.ddmh.service.spi.ColumnAuditRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 列变更记录 spi impl
 *
 * @author FBin
 * @version 2019/4/10 11:52
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ColumnAuditRecordServiceImpl implements ColumnAuditRecordService {

    @Autowired
    private ColumnAuditRecordMapper columnAuditRecordMapper;



}
