package com.ddmh.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 通用的工具类
 *
 * @author FBin
 * @version 2019/4/10 12:49
 */
public class CommonUtils {

    public static String getId(){
        Random random = new Random();
        int randNum = random.nextInt(9);
        return UUID.randomUUID().toString().replaceAll("-", DataConvertUtils.getString(randNum));
    }

}
