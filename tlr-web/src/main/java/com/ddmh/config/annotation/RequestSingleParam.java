package com.ddmh.config.annotation;

import java.lang.annotation.*;

/**
 * @author FBin
 * @version 2019/4/11 13:22
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestSingleParam {

    String value();

    boolean required() default true;

    String defaultValue() default "";

}
