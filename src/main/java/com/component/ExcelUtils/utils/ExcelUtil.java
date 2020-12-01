package com.component.ExcelUtils.utils;

import com.component.test.ExcelUtils.componemet.IExcelComponent;
import com.component.test.ExcelUtils.containers.ComponentContainer;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:14
 */
public class ExcelUtil {
    private static IExcelComponent component;

    public ExcelUtil() {
    }

    public static Boolean isExists() {
        if (component == null) {
            component = (IExcelComponent) ComponentContainer.get(IExcelComponent.class, "缺少iotits-excel模块！");
        }

        return null != component;
    }

    public static void exportByTmpl(Map<String, String> datas, String template, String outPath, List objs, Class clz, boolean isClasspath) {
        try {
            FileOutputStream os = new FileOutputStream(outPath);
            exportByTmpl(datas, template, (OutputStream)os, objs, clz, isClasspath);
        } catch (FileNotFoundException var7) {
            //LoggerUtils.error(var7.getMessage(), var7);
        }

    }

    public static void exportByTmpl(Map<String, String> datas, String template, OutputStream os, List objs, Class clz, boolean isClasspath) {
        if (isExists()) {
            component.exportByTemplate(datas, template, os, objs, clz, isClasspath);
        }

    }

    public static void downByTmpl(Map<String, String> datas, String template, String fileName, List objs, Class clz, boolean isClasspath) {
        HttpServletResponse response = ComUtils.getResponse();
        response.setHeader("content-Type", "application/vnd.ms-excel");

        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
        } catch (UnsupportedEncodingException var9) {
            //LoggerUtils.error(var9.getMessage(), var9);
        }

        response.setCharacterEncoding("UTF-8");

        try {
            exportByTmpl(datas, template, (OutputStream)response.getOutputStream(), objs, clz, isClasspath);
        } catch (Exception var8) {
            //LoggerUtils.error(var8.getMessage(), var8);
        }

    }

    public static List<Object> readByPath(String path, Class clz) {
        return isExists() ? component.readByPath(path, clz) : null;
    }

    public static List<Object> readByBytes(byte[] bytes, Boolean isXlsx, Class clz) {
        return isExists() ? component.readByBytes(bytes, isXlsx, clz, 0, 0) : null;
    }
}
