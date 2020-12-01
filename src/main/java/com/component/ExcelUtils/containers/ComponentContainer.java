package com.component.ExcelUtils.containers;

import com.component.ExcelUtils.base.IBaseComponent;
import com.component.ExcelUtils.utils.ComUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:21
 */
public class ComponentContainer {
    private static Map<String, IBaseComponent> containers = new ConcurrentHashMap();

    public ComponentContainer() {
    }

    public static void put(String clzName, Object com) {
        containers.put(clzName, (IBaseComponent)com);
    }

    public static <T> T get(Class clz) {
        return get(clz, String.format("找不到组件，接口：%s", clz.getName()));
    }

    public static <T> T get(Class clz, String msg) {
        if (!containers.containsKey(clz.getName())) {
            if (ComUtils.isNotEmpty(msg)) {
                //LoggerUtils.error(msg);
            }

            return null;
        } else {
            return (T) containers.get(clz.getName());
        }
    }
}
