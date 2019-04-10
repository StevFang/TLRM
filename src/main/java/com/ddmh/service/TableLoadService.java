package com.ddmh.service;

import java.util.List;

/**
 * 加载 table 信息
 *
 * @author Fbin
 * @version 2019/4/9 22:44
 */
public interface TableLoadService {

    /**
     * 加载db下的table列表
     *
     * @param dbName 数据库名
     * @return
     */
    List<String> loadTableListByDbName(String dbName);

}
