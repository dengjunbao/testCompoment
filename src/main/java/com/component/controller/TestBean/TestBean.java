package com.component.controller.TestBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: bao
 * @Date: 2020/9/4 0004 11:19
 */
public class TestBean {
    public static void main(String[] args) {
                 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanConfig.class);
                 Teacher teacher = (Teacher) applicationContext.getBean("teacher");
                 teacher.setName("xiaoming");
        System.out.println(teacher.toString());

             }
}


