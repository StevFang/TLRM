package com.ddmh.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 常用mysql 字段类型枚举
 *
 * @author Fbin
 * @version 2019/4/10 7:37
 */
public enum ColumnTypeEnum {

    /**
     * varchar
     */
    Varchar("varchar", "变长字符"),

    /**
     * char
     */
    Char("char", "定长字符"),

    /**
     * text
     */
    Text("text", "文本型"),

    /**
     * longtext
     */
    LongText("longtext", "长文本型"),

    /**
     * blob
     */
    Blob("blob", "二进制文本型"),

    /**
     * int
     */
    Int("int", "整型"),

    /**
     * bigint
     */
    BigInt("bigint", "长整型"),

    /**
     * tinyint
     */
    TinyInt("tinyint", "小整型"),

    /**
     * smallint
     */
    SmallInt("smallint", "大整型"),

    /**
     * float
     */
    Float("float", "单精度浮点型"),

    /**
     * double
     */
    Double("double", "双精度浮点型"),

    /**
     * decimal
     */
    Decimal("decimal", "高精度浮点型"),

    /**
     * date
     */
    Date("date", "日期类型"),

    /**
     * datetime
     */
    DateTime("datetime", "日期时间类型");

    private String value;
    private String label;

    ColumnTypeEnum(String value, String label){
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ColumnTypeEnum getByValue(String value){
        if(StringUtils.isNotBlank(value)){
            for(ColumnTypeEnum columnTypeEnum : ColumnTypeEnum.values()){
                if(columnTypeEnum.getValue().equals(value)){
                    return columnTypeEnum;
                }
            }
        }
        return null;
    }
}
