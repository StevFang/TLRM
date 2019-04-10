package com.ddmh.service.biz;

import java.util.List;

/**
 * 加载 database 信息 接口
 *
 * @author FBin
 * @version 2019/4/9 18:26
 */
public interface DbLoadService {

    /**
     * 加载db 列表
     *
     * @return
     */
    List<String> loadDbList();

}
