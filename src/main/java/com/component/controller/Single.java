package com.component.controller;

import com.component.entity.Person;
import com.component.test.entity.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: bao
 * @Date: 2019/10/15 0:51
 */
public enum Single {
    SINGLE;
    Person person = null;

    private Single(){
        person = new Person();
        System.out.println("new Person");
    }

    public Person getSingle(){
        return person;
    }
}
class TestMain {
    public static void main(String[] args) {
        /*System.out.println("Ready");
        Person person1 = Single.SINGLE.getSingle();
        System.out.println(person1);
        Person person2 = Single.SINGLE.getSingle();
        System.out.println(person2);
        System.out.println(person1 == person2);*/

        String str = "13112364585|-47,13112364586|-47,13112364587|-47,";
        String[] arr = str.split(",");
        Map map = new HashMap();
        for(String s : arr){
            String[] s2 =  s.split("\\|");
            map.put(s2[0],s2[1]);
        }
        System.out.println(map);

    }
}