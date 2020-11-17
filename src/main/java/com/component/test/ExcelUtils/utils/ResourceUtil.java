package com.component.test.ExcelUtils.utils;

import com.component.test.ExcelUtils.componemet.IResourceComponent;
import com.component.test.ExcelUtils.containers.ComponentContainer;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:46
 */
public class ResourceUtil {
    private static IResourceComponent component;

    public ResourceUtil() {
    }

    public static Boolean isExists() {
        if (component == null) {
            component = (IResourceComponent) ComponentContainer.get(IResourceComponent.class, "缺少iotits-frame模块！");
        }

        return null != component;
    }

    public static String getTpl(String key) {
        return isExists() ? component.getTpl(key, (String)null) : key;
    }

    public static String getTpl(String key, String defValue) {
        return isExists() ? component.getTpl(key, defValue) : defValue;
    }

    public static String getLan(String key) {
        return isExists() ? component.getLan(key, (String)null) : key;
    }

    public static String getLan(String key, String defValue) {
        return isExists() ? component.getLan(key, defValue) : defValue;
    }

    public static String getImg(String key) {
        return isExists() ? component.getImg(key, (String)null) : key;
    }

    public static String getImg(String key, String defValue) {
        return isExists() ? component.getImg(key, defValue) : defValue;
    }

    public static String getCnf(String key) {
        return isExists() ? component.getCnf(key, (String)null) : "";
    }

    public static String getCnf(String key, String defValue) {
        return isExists() ? component.getCnf(key, defValue) : defValue;
    }
}

