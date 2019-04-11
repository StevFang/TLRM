package com.ddmh.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author FBin
 * @version 2019/4/9 15:00
 */
public class DateUtils {

    public enum Pattern{

        /**
         * 日期
         */
        PATTERN_DATE_1("yyyy-MM-dd"),

        /**
         * 日期
         */
        PATTERN_DATE_2("yyyyMMdd"),

        /**
         * 日期时间(不包含秒)
         */
        PATTERN_DATETIME_1("yyyy-MM-dd HH:mm"),

        /**
         * 日期时间(含秒)
         */
        PATTERN_DATETIME_2("yyyy-MM-dd HH:mm:ss"),

        /**
         * 时间(不含秒)
         */
        PATTERN_TIME_1("HH:mm"),

        /**
         * 时间(含秒)
         */
        PATTERN_TIME_2("HH:mm:ss");

        private String value;

        Pattern(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static String format(Date date, Pattern pattern){
        if(date == null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(pattern.getValue());
        return sdf.format(date);
    }

    public static Date parse(String date){
        if(StringUtils.isBlank(date)){
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date addDay(Date date, int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static Date now(){
        return new Date();
    }
}
