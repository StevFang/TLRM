package com.ddmh.utils;

import com.ddmh.condition.BasePageCondition;

/**
 * @author Fbin
 * @version 2019/4/9 23:34
 */
public class PaginationUtils {

    public static int getPages(int count, int pageSize){
        return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    public static void enrichMysqlPageStartAndEnd(BasePageCondition abstractCondition){
        int start = abstractCondition.getPageSize() * (abstractCondition.getCurrent() - 1);
        abstractCondition.setStart(start);
        abstractCondition.setEnd(abstractCondition.getPageSize());
    }

}
