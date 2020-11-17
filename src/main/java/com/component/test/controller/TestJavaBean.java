
package com.component.test.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.Applet;

/**
 * @Author: bao
 * @Date: 2019/5/31 13:33
 */

/**
 * 实体类实现init方法和BeanNameAware接口
 */

public class TestJavaBean extends Applet implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private BeanFactory bf;
    private ApplicationContext context;
    private String name;
    @Override
    public void setBeanName(String arg0) {
        System.out.println("回调setBeanName方法  id属性是"+arg0);

    }
    @Override
    public void init(){
        System.out.println("正在执行初始化方法init");
    }


/*
     * 重写setBeanFactory方法
     * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
     */
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        this.bf=arg0;

    }
    public BeanFactory getBf() {
        return bf;
    }
    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        this.context=arg0;

    }
    public ApplicationContext getContext() {
        return context;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestJavaBean testJavaBean = context.getBean("testJavaBean", TestJavaBean.class);
        System.out.println(testJavaBean.toString());
        System.out.println("得到beanFactory对象 " + testJavaBean.getBf());
        System.out.println("得到的applicationContext对象:" + testJavaBean.getContext());
    }
}
