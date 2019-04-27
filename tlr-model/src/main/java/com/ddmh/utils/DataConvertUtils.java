package com.ddmh.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 数据格式转换工具类
 *
 * @author FBin
 * @version 2019/4/9 15:01
 */
public class DataConvertUtils {

    private static DecimalFormat df = new DecimalFormat();

    public enum DecimalPlaceEnum {

        /**
         * 浮点数保留两个小数位
         */
        TWO_DECIMAL_PLACE("0.00");

        private String value;
        DecimalPlaceEnum(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static String formatDecimal(BigDecimal decimal, DecimalPlaceEnum decimalPlace){
        if(decimal == null){
            return null;
        }
        df.applyPattern(decimalPlace.getValue());
        return df.format(decimal);
    }

    public static String getString(Object obj){
        if(obj == null){
            return null;
        }
        return obj.toString();
    }

    public static Integer getInteger(Object data){
        if(data == null){
            return 0;
        }
        if(data instanceof Integer){
            return (Integer) data;
        }
        try{
            return Integer.valueOf(getString(data));
        }catch (NumberFormatException e){
            return 0;
        }
    }

}
