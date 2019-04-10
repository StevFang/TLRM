package com.ddmh.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * db load mapper
 *
 * @author FBin
 * @version 2019/4/9 18:27
 */
@Repository
public interface DbMapper {

    /**
     * 获取db 列表
     *
     * @return
     */
    List<String> loadDbList();
}
