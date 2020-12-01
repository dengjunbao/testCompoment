package com.component.service.impl;

import com.component.service.Subject;

/**
 * @Author: bao
 * @Date: 2019/5/14 10:23
 */
public class RealSubject implements Subject
{
    @Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }
}
