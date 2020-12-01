package com.component.entity;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 494L;
    private String name;
    private int age;
    private String sex;

    public Person (){
        super();
    }

    public Person (String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    //seter , getter,toString方法
}