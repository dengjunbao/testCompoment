package com.component.ExcelUtils.componemet;

import com.component.ExcelUtils.base.IBaseComponent;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 15:16
 */

public interface IExcelComponent extends IBaseComponent {
    void exportByTemplate(Map<String, String> var1, String var2, OutputStream var3, List var4, Class var5, boolean var6);

    void exportByTemplate(Map<String, String> var1, String var2, String var3, List var4, Class var5, boolean var6);

    void exportByTemplate(Properties var1, String var2, OutputStream var3, List var4, Class var5, boolean var6);

    void exportByTemplate(Properties var1, String var2, String var3, List var4, Class var5, boolean var6);

    void export(String var1, List var2, Class var3);

    void export(OutputStream var1, List var2, Class var3);

    List<Object> readByClasspath(String var1, Class var2, int var3, int var4);

    List<Object> readByPath(String var1, Class var2, int var3, int var4);

    List<Object> readByClasspath(String var1, Class var2);

    List<Object> readByBytes(byte[] var1, Boolean var2, Class var3, int var4, int var5);

    List<Object> readByPath(String var1, Class var2);
}
