package com.component.controller;

import java.applet.Applet;
import java.io.*;

/**
 * @Author: bao
 * @Date: 2019/5/28 9:00
 */
public class IOController extends TestFile{
    String str = "Str";

    public static void testIO(){
        File filetest = new File("F:/test/test3.txt");
        if (!filetest.isDirectory()){
            System.out.println("文件夹不存在");
        }else {
            System.out.println("文件夹存在");
        }
        if (!filetest.exists()){
            System.out.println("文件不存在");
        }else {
            System.out.println("文件存在");
        }
        if (!filetest.isFile()){
            System.out.println("不是文件");
        }else {
            System.out.println("是文件");
        }
        try {
            File file = new File("F:/test/test3.txt");
            if (!file.isFile()){
                System.out.println("不存在");
                System.out.println(file.createNewFile());
                file.createNewFile();
            } else {
                FileOutputStream fos = new FileOutputStream(file,true);
                OutputStreamWriter out =new OutputStreamWriter(fos,"utf-8");
                BufferedWriter bw = new BufferedWriter(out);
                bw.write("写入......");
                bw.write("\r\n");
                bw.flush();
                System.out.println("写入成功！");
                fos.close();
                out.close();
                bw.close();
            }
            file.delete();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String str = "123456789qwe";
        System.out.println(str);
        System.out.println("替换后");
        str = str.replace("9q","oo");
        System.out.println(str);
    }

    public static void main(String[] args) {
        // testIO();
        IOController ioController = new IOController();
        System.out.println(ioController.str);
    }
}
