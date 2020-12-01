package com.component.controller;
import com.component.entity.Position;
import com.component.test.entity.Position;

import java.io.*;

public class TimerTask extends java.util.TimerTask {
    //    private Position position;
    @Override
    public void run() {
        for (int i=0;i<=1000000;i++) {
            double lng = ((double) (1214600 + i)) / 10000;
            double lat = ((double) (312200)) / 10000;
            String carName1 = "粤C888888";
            String degreeCelsius1 = "16摄氏度";
//          double lng2 = ((double) (1214600 + i)) / 10000;
//          double lat2 = ((double) (312200+(2*i))) / 10000;
//          String carName2 = "粤C111111";
//          String degreeCelsius2 = "26摄氏度";
            Position position = new Position();
            position.setNewPoint(lng+","+lat);
            position.setLng(lng);
            position.setLat(lat);
            position.setDegreeCelsius(degreeCelsius1);
            position.setCarNumber(carName1);
            savePosition(position);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void savePosition(Position position){
        String url = "E:\\GPStest\\"+position.getCarNumber()+".txt";
        File positionFile = new File(url);//文件路径
        if (!positionFile.exists()){
            positionFile.mkdirs();
        }
        /** 保留旧坐标，再重写*/
        try{
            String readData;
            String readDataLine[];
            FileReader fr = new FileReader(positionFile);
            BufferedReader br = new BufferedReader(fr);
            while ((readData = br.readLine())!=null){//没有读到文件尾的s时候
                try{
                    readDataLine = readData.split(",");
                    position.setPrvePoint(readDataLine[0]+","+readDataLine[1]);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        /**----------------------------------------------------------*/
        try {
            FileWriter fileWriter =new FileWriter(positionFile);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            FileWriter fw = new FileWriter(positionFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(position.getlng())+",");//这里要写String类型,先写经度
            bw.write(String.valueOf(position.getLat())+",");//写纬度
            bw.write(String.valueOf(position.getPrvePoint())+",");//写旧坐标
            bw.write(String.valueOf(position.getDegreeCelsius())+",");//写温度
            bw.write(String.valueOf(position.getCarNumber())+",");//写车牌号
            bw.write(String.valueOf(position.getDegreeCelsius())+"\n");//写温度
            bw.flush();
            bw.close();
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
