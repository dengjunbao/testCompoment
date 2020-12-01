package com.component.test.controller.TestAspect.testInterface;

/**
 * @Author: bao
 * @Date: 2020/3/31 22:06
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD}) //使用范围是参数和方法
@Retention(RetentionPolicy.RUNTIME) //生命周期是运行时依然有效
public @interface LogPrint{
    //可附加属性
    String desc();//注意属性后面有括号
}
