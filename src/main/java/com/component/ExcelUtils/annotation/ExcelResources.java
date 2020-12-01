package com.component.ExcelUtils.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:06
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResources {
    String title();

    int width() default 0;

    int order() default 9999;

    String align() default "center";

    String validity() default "";
}
