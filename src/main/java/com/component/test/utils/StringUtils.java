package com.component.test.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * @Author: bao
 * @Date: 2020/6/4 0004 9:15
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public StringUtils() {
    }

    public static boolean isBlank(Object... objects) {
        Boolean result = false;
        Object[] var2 = objects;
        int var3 = objects.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object object = var2[var4];
            if (null == object || "".equals(object.toString().trim()) || "null".equals(object.toString().trim())) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static String getRandom(int length) {
        String val = "";
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val = val + (char)(choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val = val + String.valueOf(random.nextInt(10));
            }
        }

        return val.toLowerCase();
    }

    public static boolean isNotBlank(Object... objects) {
        return !isBlank(objects);
    }

    public static boolean isBlank(String... objects) {
        return isBlank((Object[])objects);
    }

    public static boolean isNotBlank(String... objects) {
        return !isBlank((Object[])objects);
    }

    public static boolean isBlank(String str) {
        return isBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static int indexOf(String baseStr, String[] strings) {
        if (null != baseStr && baseStr.length() != 0 && null != strings) {
            int i = 0;
            String[] var3 = strings;
            int var4 = strings.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String string = var3[var5];
                boolean result = baseStr.equals(string);
                int var10000;
                if (result) {
                    ++i;
                    var10000 = i;
                } else {
                    var10000 = i;
                }

                i = var10000;
            }

            return i;
        } else {
            return 0;
        }
    }

    public static JSONObject isJSONObject(String args) {
        JSONObject result = null;
        if (isBlank(args)) {
            return (JSONObject)result;
        } else {
            try {
                return JSONObject.parseObject(args.trim());
            } catch (Exception var3) {
                return (JSONObject)result;
            }
        }
    }

    public static JSONArray isJSONArray(Object args) {
        JSONArray result = new JSONArray();
        if (isBlank(args)) {
            return null;
        } else if (!(args instanceof JSONArray)) {
            return null;
        } else {
            JSONArray arr = (JSONArray)args;
            Iterator var3 = arr.iterator();

            while(true) {
                while(var3.hasNext()) {
                    Object json = var3.next();
                    if (json != null && json instanceof JSONObject) {
                        result.add(json);
                    } else {
                        result.add(JSONObject.toJSON(json));
                    }
                }

                return result;
            }
        }
    }

    public static String trimToEmpty(Object str) {
        return isBlank(str) ? "" : str.toString().trim();
    }

    public static String getBASE64(String str, boolean... bf) {
        if (isBlank(str)) {
            return null;
        } else {
            String base64 = (new BASE64Encoder()).encode(str.getBytes());
            if (isBlank(bf) && bf[0]) {
                base64 = base64.replaceAll("=", "");
            }

            return base64;
        }
    }

    public static String getStrByBASE64(String s) {
        if (isBlank(s)) {
            return "";
        } else {
            BASE64Decoder decoder = new BASE64Decoder();

            try {
                byte[] b = decoder.decodeBuffer(s);
                return new String(b);
            } catch (Exception var3) {
                return "";
            }
        }
    }

    public static String mapToGet(Map<? extends Object, ? extends Object> map) {
        String result = "";
        if (map != null && map.size() != 0) {
            Set<? extends Object> keys = map.keySet();

            Object key;
            for(Iterator var3 = keys.iterator(); var3.hasNext(); result = result + key + "=" + map.get(key) + "&") {
                key = var3.next();
            }

            return isBlank(result) ? result : result.substring(0, result.length() - 1);
        } else {
            return result;
        }
    }

    public static Map<String, ? extends Object> getToMap(String args) {
        if (isBlank(args)) {
            return null;
        } else {
            args = args.trim();
            if (args.startsWith("?")) {
                args = args.substring(1);
            }

            String[] argsArray = args.split("&");
            Map<String, Object> result = new HashMap();
            String[] var3 = argsArray;
            int var4 = argsArray.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String ag = var3[var5];
                if (!isBlank(ag) && ag.indexOf("=") > 0) {
                    String[] keyValue = ag.split("=");
                    String key = keyValue[0];
                    String value = "";

                    for(int i = 1; i < keyValue.length; ++i) {
                        value = value + keyValue[i] + "=";
                    }

                    value = value.length() > 0 ? value.substring(0, value.length() - 1) : value;
                    result.put(key, value);
                }
            }

            return result;
        }
    }

    public static String toUnicode(String str) {
        String[] as = new String[str.length()];
        String s1 = "";

        for(int i = 0; i < str.length(); ++i) {
            int v = str.charAt(i);
            if (v >= 19968 && v <= 171941) {
                as[i] = Integer.toHexString(str.charAt(i) & '\uffff');
                s1 = s1 + "\\u" + as[i];
            } else {
                s1 = s1 + str.charAt(i);
            }
        }

        return s1;
    }

    public static String merge(Object... v) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < v.length; ++i) {
            sb.append(v[i]);
        }

        return sb.toString();
    }

    public static String strToUrlcode(String value) {
        try {
            value = URLEncoder.encode(value, "utf-8");
            return value;
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static String urlcodeToStr(String value) {
        try {
            value = URLDecoder.decode(value, "utf-8");
            return value;
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static Boolean containsCN(String txt) {
        if (isBlank(txt)) {
            return false;
        } else {
            for(int i = 0; i < txt.length(); ++i) {
                String bb = txt.substring(i, i + 1);
                boolean cc = Pattern.matches("[一-龥]", bb);
                if (cc) {
                    return cc;
                }
            }

            return false;
        }
    }

    public static Map<String, Object> toUnicodeByMap(Map<String, Object> map) {
        Iterator var1 = map.keySet().iterator();

        while(var1.hasNext()) {
            String key = (String)var1.next();
            if (map.get(key) instanceof String) {
                String con = map.get(key).toString();
                if (containsCN(con)) {
                    map.put(key, toUnicode(con));
                }
            }
        }

        return map;
    }

    public static String removeHtml(String news) {
        String s = news.replaceAll("amp;", "").replaceAll("<", "<").replaceAll(">", ">");
        Pattern pattern = Pattern.compile("<(span)?\\sstyle.*?style>|(span)?\\sstyle=.*?>", 32);
        Matcher matcher = pattern.matcher(s);
        String str = matcher.replaceAll("");
        Pattern pattern2 = Pattern.compile("(<[^>]+>)", 32);
        Matcher matcher2 = pattern2.matcher(str);
        String strhttp = matcher2.replaceAll(" ");
        String regEx = "(((http|https|ftp)(\\s)*((\\:)|：))(\\s)*(//|//)(\\s)*)?([\\sa-zA-Z0-9(\\.|．)(\\s)*\\-]+((\\:)|(:)[\\sa-zA-Z0-9(\\.|．)&%\\$\\-]+)*@(\\s)*)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([\\sa-zA-Z0-9\\-]+(\\.|．)(\\s)*)*[\\sa-zA-Z0-9\\-]+(\\.|．)(\\s)*[\\sa-zA-Z]*)((\\s)*(\\:)|(：)(\\s)*[0-9]+)?(/(\\s)*[^/][\\sa-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$\\=~_\\-@]*)*";
        Pattern p1 = Pattern.compile(regEx, 32);
        Matcher matchhttp = p1.matcher(strhttp);
        String strnew = matchhttp.replaceAll("").replaceAll("(if[\\s]*\\(|else|elseif[\\s]*\\().*?;", " ");
        Pattern patterncomma = Pattern.compile("(&[^;]+;)", 32);
        Matcher matchercomma = patterncomma.matcher(strnew);
        String strout = matchercomma.replaceAll(" ");
        String answer = strout.replaceAll("[\\pP‘’“”]", " ").replaceAll("\r", " ").replaceAll("\n", " ").replaceAll("\\s", " ").replaceAll("　", "");
        return answer;
    }

    public static List<String> array2Empty(String[] array) {
        List<String> list = new ArrayList();
        String[] var2 = array;
        int var3 = array.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String string = var2[var4];
            if (isNotBlank(string)) {
                list.add(string);
            }
        }

        return list;
    }

    public static Set<?> array2Set(Object[] array) {
        Set<Object> set = new TreeSet();
        Object[] var2 = array;
        int var3 = array.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object id = var2[var4];
            if (null != id) {
                set.add(id);
            }
        }

        return set;
    }

    public static String toString(Serializable serializable) {
        if (null == serializable) {
            return null;
        } else {
            try {
                return (String)serializable;
            } catch (Exception var2) {
                return serializable.toString();
            }
        }
    }

    public static String join(List<String> list) {
        return String.join(",", list);
    }

    public static String[] toArray(String str) {
        String[] array = new String[str.length()];

        for(int i = 0; i < str.length(); ++i) {
            array[i] = String.valueOf(str.charAt(i));
        }

        return array;
    }

    public static List<Integer> string2IntList(String str) {
        String[] arr = split(str, ",");
        List<Integer> ret = new ArrayList();
        if (arr.length > 0) {
            String[] var3 = arr;
            int var4 = arr.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String val = var3[var5];
                ret.add(Integer.parseInt(val));
            }
        }

        return ret;
    }

    public static List<String> string2List(String str) {
        String[] arr = split(str, ",");
        List<String> ret = new ArrayList();
        if (arr.length > 0) {
            String[] var3 = arr;
            int var4 = arr.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String val = var3[var5];
                ret.add(val);
            }
        }

        return ret;
    }

    public static String ToFirstChar(String chinese) {
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        for(int i = 0; i < newChar.length; ++i) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr = pinyinStr + PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0].charAt(0);
                } catch (Exception var6) {
                }
            } else {
                pinyinStr = pinyinStr + newChar[i];
            }
        }

        return pinyinStr;
    }

    public static String ToPinyin(String chinese) {
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        for(int i = 0; i < newChar.length; ++i) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr = pinyinStr + PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0];
                } catch (Exception var6) {
                }
            } else {
                pinyinStr = pinyinStr + newChar[i];
            }
        }

        return pinyinStr;
    }
}
