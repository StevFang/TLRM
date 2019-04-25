package com.ddmh.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 索引类型
 *
 * @author Fbin
 * @version 2019/4/10 7:28
 */
public enum IndexTypeEnum {

    /**
     * primary index
     */
    PrimaryIndex("PrimaryIndex", "主键索引"),

    /**
     * common index
     */
    CommonIndex("CommonIndex", "普通索引"),

    /**
     * unique index
     */
    UniqueIndex("UniqueIndex", "唯一索引"),

    /**
     * combination index
     */
    CombinationIndex("CombinationIndex", "组合索引"),

    /**
     * fuzzy text index
     */
    FuzzyTextIndex("FuzzyTextIndex", "全文索引");

    private String value;
    private String label;

    IndexTypeEnum(String value, String label){
        this.value = value;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public static IndexTypeEnum getByValue(String value){
        if(StringUtils.isNotBlank(value)){
            for(IndexTypeEnum indexTypeEnum : IndexTypeEnum.values()){
                if(indexTypeEnum.getValue().equals(value)){
                    return indexTypeEnum;
                }
            }
        }
        return null;
    }

}
