package com.ddmh.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * json 格式化工具
 *
 * @author Fbin
 * @version 2019/4/9 22:25
 */
public class JsonUtils {

    public static Object success(){
        return success(null);
    }

    public static Object success(Object object){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("message", "");
        jsonObject.put("data", object);
        return jsonObject;
    }

    public static Object error(String errorMessage){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "-1");
        jsonObject.put("message", errorMessage);
        return jsonObject;
    }

    public static Object parse(Object object){
        return JSONObject.parseObject(JSONObject.toJSONString(object));
    }

}
