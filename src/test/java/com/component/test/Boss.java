package com.component.test;

/**
 * @Author: bao
 * @Date: 2019/6/2 1:45
 */
public class Boss implements CallBack {


    private Emp emp = new Emp();

    public void play(){
            System.out.println("我出去玩了");
    }

    public void doSomeThing(){
        for (int i = 0; i<1; i++) {
            new Thread(new Runnable() {
                public void run() {
                    emp.work(Boss.this);
                }
            }).start();
        this.play();
        }
    }



    @Override
    public void call(String info) {
        System.out.println(info);
    }

    public void call2(String info,String name) {
        System.out.println(info+" by "+name);
    }
}
class Emp{
    public void work(CallBack callBack){
        System.out.println("我接手项目");
        System.out.println("正在工作");
        System.out.println("工作完成");
        callBack.call("老板的工作做我好了");
        callBack.call2("worker","小明");

        System.out.println("=====================================================");
    }
}
