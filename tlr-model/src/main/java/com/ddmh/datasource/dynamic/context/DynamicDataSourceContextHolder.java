package com.ddmh.datasource.dynamic.context;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 动态数据源上下文
 *
 * @author fbin
 * @version 2019/4/27 08:00
 */
public class DynamicDataSourceContextHolder {

    /**
     * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本
     * 所以每个线程都可以独立的改变自己的副本，而不会影响其它线程所对应的副本
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 管理所有的数据源id
     * 为了判断数据源是否存在
     */
    private static List<String> dataSourceIds = Lists.newArrayList();

    /**
     * 使用setDataSourceType设置当前的
     *
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }


    public static String getDataSourceType() {
        return contextHolder.get();
    }


    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    /**
     * 判断指定DataSource当前是否存在
     *
     * @param dataSourceId
     * @return
     */
    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }

    public static List<String> getDataSourceIds() {
        return dataSourceIds;
    }

    public static void setDataSourceIds(List<String> dataSourceIds) {
        DynamicDataSourceContextHolder.dataSourceIds = dataSourceIds;
    }
}
