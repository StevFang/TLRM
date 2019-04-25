package com.ddmh.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 标识枚举
 *
 * @author Fbin
 * @version 2019/4/10 7:34
 */
public enum FlagEnum {

    /**
     * flag of true
     */
    Yes("Y", "是"),

    /**
     * flag of false
     */
    No("N", "否");

    private String value;
    private String label;

    FlagEnum(String value, String label){
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static FlagEnum getByValue(String value){
        if(StringUtils.isNotBlank(value)){
            for(FlagEnum flagEnum : FlagEnum.values()){
                if(flagEnum.getValue().equals(value)){
                    return flagEnum;
                }
            }
        }
        return null;
    }
}
