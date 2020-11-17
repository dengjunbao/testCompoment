package com.component.test.ExcelUtils.utils;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:24
 */
public class BeanUtil extends BeanUtils {
    public BeanUtil() {
    }

    public static Map<Object, Object> bean2Map(Object bean) {
        Map<Object, Object> map = new HashMap();
        BeanMap beanMap = new BeanMap(bean);
        Iterator var3 = beanMap.keySet().iterator();

        while(var3.hasNext()) {
            Object key = var3.next();
            map.put(key, beanMap.get(key));
        }

        return map;
    }

    public static <T> T map2Bean(Map<Object, Object> map, Class<T> clz) {
        Object bean = null;

        try {
            bean = clz.newInstance();
            copyProperties(bean, map);
        } catch (InstantiationException var4) {
            var4.printStackTrace();
        } catch (IllegalAccessException var5) {
            var5.printStackTrace();
        } catch (InvocationTargetException var6) {
            var6.printStackTrace();
        }

        return (T) bean;
    }

    public static <T> T object2Bean(Object obj, Class<T> class1) {
        return ComUtils.map2Bean(bean2Map(obj), class1);
    }

    public static Object mapToObject(Map map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        } else {
            Object obj = beanClass.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            Field[] var4 = fields;
            int var5 = fields.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Field field = var4[var6];
                if (map.get(field.getName()) != null || StringUtils.isEmpty(map.get(field.getName()))) {
                    int mod = field.getModifiers();
                    if (!Modifier.isStatic(mod) && !Modifier.isFinal(mod)) {
                        field.setAccessible(true);
                        field.set(obj, map.get(field.getName()));
                    }
                }
            }

            return obj;
        }
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        } else {
            Map<String, Object> map = new HashMap();
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            Field[] var3 = declaredFields;
            int var4 = declaredFields.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Field field = var3[var5];
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }

            return map;
        }
    }

    public static String[] getNoValuePropertyNames(Object source) {
        Assert.notNull(source, "传递的参数对象不能为空");
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
        Set<String> noValuePropertySet = new HashSet();
        Arrays.stream(pds).forEach((pd) -> {
            Object propertyValue = beanWrapper.getPropertyValue(pd.getName());
            if (StringUtils.isEmpty(propertyValue)) {
                noValuePropertySet.add(pd.getName());
            } else {
                if (Iterable.class.isAssignableFrom(propertyValue.getClass())) {
                    Iterable iterable = (Iterable)propertyValue;
                    Iterator iterator = iterable.iterator();
                    if (!iterator.hasNext()) {
                        noValuePropertySet.add(pd.getName());
                    }
                }

                if (Map.class.isAssignableFrom(propertyValue.getClass())) {
                    Map map = (Map)propertyValue;
                    if (map.isEmpty()) {
                        noValuePropertySet.add(pd.getName());
                    }
                }
            }

        });
        String[] result = new String[noValuePropertySet.size()];
        return (String[])noValuePropertySet.toArray(result);
    }
}

