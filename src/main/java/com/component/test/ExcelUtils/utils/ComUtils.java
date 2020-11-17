package com.component.test.ExcelUtils.utils;

import com.alibaba.fastjson.JSON;
import com.component.test.ExcelUtils.base.BaseModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:22
 */
public class ComUtils {
    private static Map<Integer, String> warnType = new LinkedHashMap();
    private static Map<String, Cipher> ciphers = new ConcurrentHashMap();

    public ComUtils() {
    }

    public static String getString(InputStream input) {
        if (input == null) {
            return "";
        } else {
            byte[] buf = new byte[1024];
            StringBuffer stringbuf = new StringBuffer();

            try {
                int len;
                while((len = input.read(buf)) != -1) {
                    stringbuf.append(new String(buf, 0, len, StandardCharsets.UTF_8));
                }

                return stringbuf.toString();
            } catch (IOException var4) {
                var4.printStackTrace();
                return "";
            }
        }
    }


    public static String base64_encode(String str) {
        String ret = "";
        if (isNotEmpty(str)) {
            ret = base64_encode(str.getBytes());
        }

        return ret;
    }

    public static String base64_encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static byte[] base64_decode(String str) {
        return Base64.decodeBase64(str);
    }


    public static synchronized String encrypt(String key, byte[] value) {
        try {
            byte[] encrypted = getSecretCipher(key, 1).doFinal(value);
            return base64_encode(encrypted);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static synchronized Cipher getSecretCipher(String secretKey, int mode) throws Exception {
        String key = secretKey + "#" + mode;
        if (!ciphers.containsKey(key)) {
            String initVector = secretKey.substring(0, 16);
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(mode, skeySpec, iv);
            ciphers.put(key, cipher);
            return cipher;
        } else {
            return (Cipher)ciphers.get(key);
        }
    }

    public static synchronized byte[] decrypt(String key, String encrypted) {
        try {
            return getSecretCipher(key, 2).doFinal(base64_decode(encrypted));
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Long crc32(String str) {
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        Long crc = crc32.getValue();
        return crc;
    }

    public static Map<Object, Object> bean2Map(Object bean) {
        return BeanUtil.bean2Map(bean);
    }

    public static <T> T map2Bean(Map<Object, Object> map, Class<T> clz) {
        return BeanUtil.map2Bean(map, clz);
    }

    public static <T> T object2Bean(Object obj, Class<T> clz) {
        return map2Bean(bean2Map(obj), clz);
    }

    public static String parseSplit(String str, String regex) {
        if (!"".equals(str) && str != null) {
            String result = str.replaceAll(regex, ",");
            if (result.charAt(0) == ',') {
                result = result.substring(1);
            }

            if (result.charAt(result.length() - 1) == ',') {
                result = result.substring(0, result.length() - 1);
            }

            return result;
        } else {
            return str;
        }
    }

    public static Integer[] parseIntegerArray(String str) {
        String[] temp = str.split(",");
        Integer[] result = new Integer[temp.length];

        for(int i = 0; i < temp.length; ++i) {
            result[i] = Integer.parseInt(temp[i]);
        }

        return result;
    }


    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return null != RequestContextHolder.getRequestAttributes() ? ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse() : null;
    }

    public static void dump(Object obj) {
        String str = JSON.toJSONString(obj);
        dump(str);
    }


    public static void dump(String str) {
        System.out.println(str);
    }

    public static Boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static Boolean isEmpty(Number val) {
        return val == null || val.longValue() <= 0L;
    }

    public static Boolean isEmpty(Collection list) {
        return null == list || list.size() <= 0;
    }

    public static Boolean isEmpty(Map map) {
        return null == map || map.size() <= 0;
    }

    public static Boolean isNotEmpty(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Map) {
            return !isEmpty((Map)obj);
        } else if (obj instanceof Collection) {
            return !isEmpty((Collection)obj);
        } else if (obj instanceof String) {
            return !isEmpty((String)obj);
        } else if (obj instanceof Number) {
            return !isEmpty((Number)obj);
        } else if (obj instanceof Boolean) {
            return (Boolean)obj;
        } else {
            //LoggerUtils.error("判空函数不支持该数据类型：" + obj.getClass().getName());
            return false;
        }
    }

    public static String getHost() {
        HttpServletRequest request = getRequest();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }

    public static void setAllowOrigin(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Access-Control-Allow-Origin,EX-SysAuthToken,EX-JSESSIONID");
    }

    public static String mergeIds(String str1, String str2) {
        List<String> ids1 = Arrays.asList(StringUtils.split(str1, ","));
        List<String> ids2 = Arrays.asList(StringUtils.split(str2, ","));
        List<String> ids = new ArrayList();
        Iterator var5 = ids1.iterator();

        String id;
        while(var5.hasNext()) {
            id = (String)var5.next();
            ids.add(id);
        }

        var5 = ids2.iterator();

        while(var5.hasNext()) {
            id = (String)var5.next();
            if (!ids1.contains(id)) {
                ids.add(id);
            }
        }

        return StringUtils.join(ids, ",");
    }

    public static List shuffle(List list) {
        return shuffle(list, System.currentTimeMillis());
    }

    public static List shuffle(List list, long seed) {
        Collections.shuffle(list, new Random(seed));
        return list;
    }
}

