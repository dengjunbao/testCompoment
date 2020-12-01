package com.component.controller;

/**
 * @Author: bao
 * @Date: 2019/5/17 16:01
 */
public enum Mgr {
    INSTANCE;
    public void m (){
        System.out.println("the m() method is run!");
    }

    public static void main(String[] args) {
        for (int i = 0; i<100; i++){
            new Thread(() -> {
                System.out.println(Mgr.INSTANCE.hashCode());
                Mgr.INSTANCE.m();
            }).start();
        }
    }
}
