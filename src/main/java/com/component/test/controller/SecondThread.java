package com.component.test.controller;

/**
 * @Author: bao
 * @Date: 2019/5/8 11:03
 */
public class SecondThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if ("线程1".equals(Thread.currentThread().getName()) && i==5){
                System.out.println("i:"+ i +",准备暂停线程1");
                Test2.waitT1();
            }
            if ("线程1".equals(Thread.currentThread().getName()) && i==10){
                System.out.println("i:"+ i +",准备恢复线程1");
                Test2.notifyT1();
            }
            if(i==20)
            {
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        }
    }
}
