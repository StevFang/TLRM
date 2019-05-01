package com.ddmh.enums;

/**
 * cdc sql message type enum
 *
 * @author fbin
 * @version 2019/5/1 0001 20:07
 */
public enum CdcSqlMessageTypeEnum {

    /**
     *
     */
    Create(0, "创建表"),
    Alter(1, "修改表"),
    Drop(2, "删除表"),
    Rename(3, "重命名表"),
    Insert(4, "新增数据"),
    Update(5, "修改数据"),
    Delete(6, "删除数据"),
    CIndex(7, "创建索引"),
    DIndex(8, "删除索引");

    private int value;
    private String label;

    CdcSqlMessageTypeEnum(int value, String label){
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static CdcSqlMessageTypeEnum getByValue(int value){
        for(CdcSqlMessageTypeEnum cdcSqlMessageTypeEnum : CdcSqlMessageTypeEnum.values()){
            if(cdcSqlMessageTypeEnum.getValue() == value){
                return cdcSqlMessageTypeEnum;
            }
        }
        return null;
    }
}
