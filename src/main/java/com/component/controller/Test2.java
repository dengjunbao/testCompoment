package com.component.controller;

import com.component.test.entity.Person;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import sun.font.BidiUtils;

import java.io.*;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@FunctionalInterface
interface MyInterface {
    void test();
    @Override
    String toString();
}

public class Test2 {

    public void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    static SecondThread s1=new SecondThread();
    static Thread t1 = new Thread(s1,"线程1");
    static Thread t2=new Thread(s1,"线程2");

    public static void go(){
        t1.start();
        t2.start();
    }

    public static void waitT1(){
        try {
            t1.wait();
            System.out.println("已暂停线程1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void notifyT1(){

        t1.notify();
        System.out.println("已恢复线程1");

    }


    public static void main(String[] args) {
        go();

        /**-------------------------------------------------------------------*/

        /*Map<String, String> map = new HashMap<String, String>();
        map.put("one","第一个键值对");
        map.put("tow","第二个键值对");
        map.put("one","hello");
        map.put("tow","word");*/
        /**--------------------------------------序列化--------------------------------------------------------------------*/
        /*Person person = new Person("xiaoming",18,"男");
        ObjectOutputStream objectOutputStream = null;
        try {
            System.out.println("--------------------------序列化-------------------------------------------------");
            System.out.println("开始序列化");
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("F:/test/person.txt"));
            objectOutputStream.writeObject(person);
            System.out.println("序列化成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        /**----------------------------------------反序列化------------------------------------------------------------------*/
        /*Person person1;
        ObjectInputStream objectInputStream = null;
        try {
            System.out.println("--------------------------反序列化-------------------------------------------------");
            System.out.println("开始反序列化");
            objectInputStream = new ObjectInputStream(new FileInputStream("F:/test/person.txt"));
            person1 = (Person) objectInputStream.readObject();
            Person p = new Person();
            BeanUtils.copyProperties(person1,p);
            System.out.println(p.getName()+p.getAge()+p.getSex());
            System.out.println(person1.getName());
            System.out.println("反序列化成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        /**-----------------------------------------------------------------------------------------------------------*/
        /*Vector vector = new Vector();
        vector.add("firstVector");
        vector.add(person);
        Person w = (Person) vector.get(1);
        System.out.println(vector.get(0)+"---"+w);

        long startTime = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("firstArrayList");
        System.out.println(arrayList.iterator().next()+"-----"+arrayList.get(0));

        String[] array = new String[]{"王磊","的微博"};
        System.out.println(array[0]);
        List list = Arrays.asList(array);
        List list1 = new ArrayList();
        list1.add(1);
        System.out.println(list1.get(0));

        String[] ss= (String[]) list.toArray(array);
        System.out.println(ss[0]+ss[1]);
        long endTime = System.currentTimeMillis();
        *//** 输出程序运行时间 *//*
        System.out.println("Array运行时间：" + (endTime - startTime) + "ms");

        long startTime2 = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        linkedList.add("oneLinkedList");
        System.out.println(linkedList.get(0));
        long endTime2 = System.currentTimeMillis();
        *//** 输出程序运行时间 *//*
        System.out.println("Linked运行时间：" + (endTime2 - startTime2) + "ms");

        HashSet set = new HashSet();
        set.add("oneSet");
        set.add("towSet");
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(set.iterator().next());*/
        /**-------------------------------------------------------------------*/

        /*System.out.println(map.keySet());
        System.out.println(map.get("one")+map.get("tow"));
        int q = 1;
        StringBuilder s = new StringBuilder();
        s.append("ab").append("cd");
        s.replace(2,2,"&&");
        s.delete(0,s.length());
        System.out.println(s);
        Test2 test2 = new Test2();
        String t = new String("ABCDEFG  ");
        System.out.println(t.equals("sdd"));
        StringBuilder y = new StringBuilder(t);
        System.out.println(y.reverse());
        t.trim();
        System.out.println(t);*/
        /**-------------------------------------------------------------------*/
        /*int i;
        i = 10;
        System.out.println(i);
        String str1 = "通话";
        String str2 = "童话";
        System.out.println(String.format("str：%d | str2:%d",str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));*/

        /**-------------------------------------------------------------------*/

        /*test2.myTest( () -> {
            System.out.println("mytest");
        });
        MyInterface myInterface = () ->{
            System.out.println("hello");
        };
        test2.myTest(myInterface);

        new Thread( () -> { System.out.println("hello haha"); }).start();

        System.out.println("-----------------------------------------------------");

        map.forEach((s12, s2) -> {
            System.out.println(s2);
        });
        list.forEach(o -> System.out.println(o));*/
    }
}
