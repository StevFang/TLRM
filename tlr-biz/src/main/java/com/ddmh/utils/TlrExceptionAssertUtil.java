package com.ddmh.utils;

import com.ddmh.exception.TlrException;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author Fbin
 * @version 2019/4/20 14:10
 */
public class TlrExceptionAssertUtil {

    public static void assertNotNull(Object obj, String message){
        if(obj == null){
            fail(message);
        }
    }

    public static void assertTrue(boolean flag, String message){
        if(!flag){
            fail(message);
        }
    }

    public static void assertNotEmpty(Collection<?> collection, String messsage){
        if(collection == null || CollectionUtils.isEmpty(collection)){
            fail(messsage);
        }
    }

    public static void fail(String message){
        throw new TlrException(message);
    }

}
