package com.component.controller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.component.entity.Position;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/gps")
public class GpsController {
    @RequestMapping(value = "/baidu")
    public String gotoBaidu() {
        return "Baidu";
    }

    @RequestMapping(value = "/getPoint")
    @ResponseBody
    //此方法返回一个最新的位置点给我
    public List<Position> getCurrentPosition() {
        Double lng;//经度
        Double lat;//纬度
        String newPoint;//旧坐标
        String prvePoint;//旧坐标
        String carNumber;//车牌号
        String degreeCelsius;//摄氏度
        List<Position> pointList = new ArrayList<Position>();//用来存储从文件中读取到的数据
        File file = new File("E:\\GPStest\\粤C888888.txt");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String readData;
            String readDataLine[];
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((readData = br.readLine()) != null) {//没有读到文件尾的s时候
                try {
                    Position position = new Position();
                    readDataLine = readData.split(",");
                    lng = Double.valueOf(readDataLine[0]);
                    lat = Double.valueOf(readDataLine[1]);
                    newPoint = readDataLine[0] + "," + readDataLine[1];
                    prvePoint = readDataLine[2] + "," + readDataLine[3];
                    carNumber = String.valueOf(readDataLine[4]);
                    degreeCelsius = String.valueOf(readDataLine[5]);
                    position.setLng(lng);
                    position.setLat(lat);
                    position.setNewPoint(newPoint);
                    position.setPrvePoint(prvePoint);
                    position.setCarNumber(carNumber);
                    position.setDegreeCelsius(degreeCelsius);
                    pointList.add(position);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pointList;
    }
}