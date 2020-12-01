package com.component.ExcelUtils.common;

import com.component.ExcelUtils.annotation.ExcelResources;
import com.component.ExcelUtils.componemet.IExcelComponent;
import com.component.ExcelUtils.excel.ExcelComponent;
import com.component.ExcelUtils.excel.ExcelHeader;
import com.component.ExcelUtils.excel.TemplateFileUtil;
import com.component.ExcelUtils.annotation.ExcelResources;
import com.component.ExcelUtils.componemet.IExcelComponent;
import com.component.ExcelUtils.excel.ExcelComponent;
import com.component.ExcelUtils.excel.ExcelHeader;
import com.component.ExcelUtils.excel.TemplateFileUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:32
 */
@Component
public class ExcelUtilsExtend extends ExcelComponent {
    private List<Integer> exceptOrder;
    private static IExcelComponent component;
    private ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();

    public ExcelUtilsExtend() {
    }

    public List<ExcelHeader> getHeaderListByclass(Class clz) {
        return this.getHeaderList(clz);
    }


    private ExcelTemplateBo handlerObj2Excel(String template, List objs, Class clz, boolean isClasspath, List<Integer> ids) {
        List<ExcelHeader> headers = this.getHeaderList(clz); //这里得到dto标题集合
        ExcelTemplateBo et = ExcelTemplateBo.getInstance();
        int len = 0;
        if (ids != null) {
            len = headers.size() - ids.size();  //得到标头的长度，然后传进去根据长度合并单元格
        }
        if (isClasspath) {
            et.readTemplateByClasspath(template, len);
        } else {
            et.readTemplateByPath(template);
        }

        if (ids != null) {
            //如果有未勾选的字段，则遍历删除dto的标题字段
            Collections.sort(ids, Collections.reverseOrder());
            for (Integer i : ids) {
                int rei = i;
                if (rei < headers.size()) {
                    headers.remove(rei);
                    //System.out.println(rei);
                }

            }
        }
        Collections.sort(headers);
        List<Map<String, Object>> infos = this.objs2Map(objs, headers);
        et.setDataHead(headers);

        try {
            Iterator var8 = objs.iterator();

            while (var8.hasNext()) {
                Object obj = var8.next();
                et.createNewRow();
                Iterator var10 = headers.iterator();

                while (var10.hasNext()) {
                    ExcelHeader eh = (ExcelHeader) var10.next();
                    et.createCell(BeanUtils.getProperty(obj, this.getMethodName(eh)));
                }
            }
        } catch (IllegalAccessException var12) {
            var12.printStackTrace();
        } catch (InvocationTargetException var13) {
            var13.printStackTrace();
        } catch (NoSuchMethodException var14) {
            var14.printStackTrace();
        }

        et.setMergedRegion(infos, headers);
        et.setRowWidth(headers);
        return et;
    }

    private String getMethodName(ExcelHeader eh) {
        String mn = eh.getMethodName().substring(3);
        mn = mn.substring(0, 1).toLowerCase() + mn.substring(1);
        return mn;
    }

    private void handelExceptOrder(Map<String, String> datas) {
        if (null != datas && StringUtils.isNotBlank((String) datas.get("-exceptOrder-"))) {
            this.exceptOrder = new ArrayList();
            String[] arr = StringUtils.split((String) datas.get("-exceptOrder-"), ",");
            String[] var3 = arr;
            int var4 = arr.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                String order = var3[var5];
                this.exceptOrder.add(Integer.parseInt(order));
            }

            datas.remove("-exceptOrder-");
        } else {
            this.exceptOrder = null;
        }

    }

    public void exportByTemplateBo(Map<String, String> datas, String template, OutputStream os, List objs, Class clz, boolean isClasspath, List<Integer> ids) {
        this.handelExceptOrder(datas);

        try {
            ExcelTemplateBo et = this.handlerObj2Excel(template, objs, clz, isClasspath, ids);
            et.replaceFinalData(datas);
            et.wirteToStream(os);
            os.flush();
            os.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }


    private Workbook handleObj2Excel(List objs, Class clz) {
        HSSFWorkbook wb = new HSSFWorkbook();

        try {
            Sheet sheet = wb.createSheet();
            Row r = sheet.createRow(0);
            List<ExcelHeader> headers = this.getHeaderList(clz);
            Collections.sort(headers);

            for (int i = 0; i < headers.size(); ++i) {
                r.createCell(i).setCellValue(((ExcelHeader) headers.get(i)).getTitle());
            }

            Object obj = null;

            for (int i = 0; i < objs.size(); ++i) {
                r = sheet.createRow(i + 1);
                obj = objs.get(i);

                for (int j = 0; j < headers.size(); ++j) {
                    r.createCell(j).setCellValue(BeanUtils.getProperty(obj, this.getMethodName((ExcelHeader) headers.get(j))));
                }
            }
        } catch (IllegalAccessException var10) {
            var10.printStackTrace();
        } catch (InvocationTargetException var11) {
            var11.printStackTrace();
        } catch (NoSuchMethodException var12) {
            var12.printStackTrace();
        }

        return wb;
    }

    @Override
    public void export(String outPath, List objs, Class clz) {
        Workbook wb = this.handleObj2Excel(objs, clz);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(outPath);
            wb.write(fos);
        } catch (FileNotFoundException var17) {
            var17.printStackTrace();
        } catch (IOException var18) {
            var18.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException var16) {
                var16.printStackTrace();
            }

        }

    }

    @Override
    public void export(OutputStream os, List objs, Class clz) {
        try {
            Workbook wb = this.handleObj2Excel(objs, clz);
            wb.write(os);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    @Override
    public List<Object> readByClasspath(String path, Class clz, int readLine, int tailLine) {
        Object wb = null;

        try {
            if (path.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(new FileInputStream(path));
            } else {
                wb = new HSSFWorkbook(TemplateFileUtil.getTemplates(path));
            }

            return this.handlerExcel2Objs((Workbook) wb, clz, readLine, tailLine);
        } catch (IOException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Object> readByPath(String path, Class clz, int readLine, int tailLine) {
        Object wb = null;

        try {
            if (path.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(new FileInputStream(path));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(path));
            }

            return this.handlerExcel2Objs((Workbook) wb, clz, readLine, tailLine);
        } catch (IOException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public List<Object> readByNetPath(String path, Class clz, int readLine, int tailLine) {
        Object wb = null;

        try {
            if (path.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(new BufferedInputStream(new URL(path).openStream()));
            } else {
                wb = new HSSFWorkbook(new BufferedInputStream(new URL(path).openStream()));
            }

            return this.handlerExcel2Objs((Workbook) wb, clz, readLine, tailLine);
        } catch (IOException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public List<Object> readByNetPath(String path, Class clz) {
        return readByNetPath(path, clz, 0, 0);
    }

    @Override
    public List<Object> readByClasspath(String path, Class clz) {
        return this.readByClasspath(path, clz, 0, 0);
    }

    @Override
    public List<Object> readByPath(String path, Class clz) {
        return this.readByPath(path, clz, 0, 0);
    }

    private String getCellValue(Cell c) {
        String o = null;
        switch (c.getCellType().getCode()) {
            case 0:
                o = String.valueOf(c.getNumericCellValue());
                break;
            case 1:
                o = c.getStringCellValue();
                break;
            case 2:
                o = String.valueOf(c.getCellFormula());
                break;
            case 3:
                o = "";
                break;
            case 4:
                o = String.valueOf(c.getBooleanCellValue());
                break;
            default:
                o = null;
        }

        return o;
    }

    public List<Object> handlerExcel2Objs(Workbook wb, Class clz, int readLine, int tailLine) {
        Sheet sheet = wb.getSheetAt(0);
        ArrayList objs = null;

        try {
            Row row = sheet.getRow(readLine);
            objs = new ArrayList();
            Map<Integer, String> maps = this.getHeaderMap(row, clz);
            if (maps == null || maps.size() <= 0) {
                throw new RuntimeException("要读取的Excel的格式不正确，检查是否设定了合适的行");
            }

            for (int i = readLine + 1; i <= sheet.getLastRowNum() - tailLine; ++i) {
                row = sheet.getRow(i);
                if (null != row) {
                    Object obj = clz.newInstance();
                    Boolean isNull = false;
                    Iterator var12 = row.iterator();

                    while (var12.hasNext()) {
                        Cell c = (Cell) var12.next();
                        if (null == c) {
                            isNull = true;
                            break;
                        }

                        int ci = c.getColumnIndex();
                        String mn = ((String) maps.get(ci)).substring(3);
                        mn = mn.substring(0, 1).toLowerCase() + mn.substring(1);
                        BeanUtils.copyProperty(obj, mn, this.getCellValue(c));
                    }

                    if (!isNull) {
                        objs.add(obj);
                    }
                }
            }
        } catch (InstantiationException var16) {
            var16.printStackTrace();
        } catch (IllegalAccessException var17) {
            var17.printStackTrace();
        } catch (InvocationTargetException var18) {
            var18.printStackTrace();
        }

        return objs;
    }

    public Map<String, Object> handlerExcel2Objs(Workbook wb, Class clz, int readLine, int tailLine, Boolean countError) {
        Map<String, Object> map = new HashMap();
        Sheet sheet = wb.getSheetAt(0);
        ArrayList objs = null;
        int state = StatusType.importStatus_fail_file;
        int rowNum = 1;
        Object cellValue;
        List errorList = new ArrayList();

        try {
            Row row = sheet.getRow(readLine);
            objs = new ArrayList();
            Map<Integer, String> maps = this.getHeaderMap(row, clz);
            if (maps == null || maps.size() <= 0 || row.getLastCellNum() != maps.size()) {
                map.put("state",state);
                return map;
            }

            for (int i = readLine + 1; i <= sheet.getLastRowNum() - tailLine; ++i) {
                try {
                    row = sheet.getRow(i);
                    rowNum = i - readLine;
                    if (null != row) {
                        Object obj = clz.newInstance();
                        Boolean isNull = false;
                        Iterator var12 = row.iterator();
                        int index = 0;
                        while (var12.hasNext()) {
                            ++index;
                            Cell c = (Cell) var12.next();
                            if (null == c || index > maps.size()) {
                                isNull = true;
                                break;
                            }
                            int ci = c.getColumnIndex();
                            String mn = ((String) maps.get(ci)).substring(3);
                            mn = mn.substring(0, 1).toLowerCase() + mn.substring(1);
                            Method method = getMethod(clz, maps.get(ci));
                            //判断模板与DTO类的配置是否一致
                            if (Objects.isNull(method)){
                                state = StatusType.importStatus_fail_file;
                                map.put("state",state);
                                return map;
                            }
                            Class[] parameterTypes = getParameterTypes(method);
                            cellValue = this.getCellValue(c);
                            //  判断是否为科学计数法（包含E、e、+等符号） 针对手机号码、身份证号码类似的值
                            if (cellValue.toString().contains("E") || cellValue.toString().contains("e") || cellValue.toString().contains("+")) {
                                BigDecimal bd = new BigDecimal(cellValue.toString());
                                cellValue = bd.toString();
                                BeanUtils.copyProperty(obj, mn, cellValue);
                                continue;
                            }
                            // 处理BigDecimal类型的值
                            if (parameterTypes[0] == BigDecimal.class){
                                Object o = convertForCopy(cellValue, String.class);
                                //避免空指针异常，为BigDecimal类型的空值字段补0
                                if (StringUtils.isEmpty(o.toString())){
                                    cellValue = new BigDecimal(0);
                                }else{
                                    BigDecimal bd = new BigDecimal(cellValue.toString());
                                    cellValue = bd;
                                }
                                BeanUtils.copyProperty(obj, mn, cellValue);
                                continue;
                            }
                            // 为原本为整数的值却因为文本框格式而存在小数点的值取整 如序号、押金月数、租金缴纳日：10.00取整为10
                            if (isDouble(cellValue.toString())){
                                Object o = convertForCopy(cellValue, String.class);
                                String stringId = String.valueOf(o);
                                Double doubleId = Double.valueOf(stringId);
                                cellValue = doubleId.intValue();
                            }
                            // 单元格为空时不插入空值，避免修改对象默认值
                            cellValue = cellValue.toString().replaceAll(" ","");
                            if (StringUtils.isNotEmpty(cellValue.toString())){
                                BeanUtils.copyProperty(obj, mn, cellValue);
                            }
                        }
                        if (!isNull) {
                            objs.add(obj);
                        }
                    }
                }catch (Exception e){
                    //LogUtil.writeLog("请检查第"+rowNum+"行数据是否正确！");
                    errorList.add(rowNum);
                    continue;
                }
            }
        } catch (Exception e){
            //LogUtil.writeLog("请检查第"+rowNum+"行数据是否正确！");
            errorList.add(rowNum);
        }

        if (errorList.size() > 0){
            map.put("error",errorList);
        }
        map.put("objs",objs);
        return map;
    }

    private Method getMethod(Class clz, String methodName) {
        Method[] ms = clz.getDeclaredMethods();
        int methodLength = ms.length;
        for (int i = 0; i < methodLength; ++i) {
            Method m = ms[i];
            String mn = m.getName();
            if (mn.equals(methodName)) {
                return m;
            }
        }
        return null;
    }

    private Class[] getParameterTypes(Method method) {
        Class[] paramTypes = method.getParameterTypes();
        return paramTypes;
    }

    private List<ExcelHeader> getHeaderList(Class clz) {
        List<ExcelHeader> headers = new ArrayList();
        Map<Integer, ExcelHeader> orders = new HashMap();
        Method[] ms = clz.getDeclaredMethods();
        Method[] var5 = ms;
        int var6 = ms.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            Method m = var5[var7];
            String mn = m.getName();
            if (mn.startsWith("get") && m.isAnnotationPresent(ExcelResources.class)) {
                ExcelResources er = (ExcelResources) m.getAnnotation(ExcelResources.class);
                orders.put(er.order(), new ExcelHeader(er.title(), er.order(), er.width(), mn));
            }
        }

        List orderList = Arrays.asList(orders.keySet());
        Integer[] arr = (Integer[]) orders.keySet().toArray(new Integer[orderList.size()]);
        Arrays.sort(arr);
        Integer[] var13 = arr;
        int var14 = arr.length;

        for (int var15 = 0; var15 < var14; ++var15) {
            Integer order = var13[var15];
            if (this.exceptOrder == null || !this.exceptOrder.contains(order)) {
                headers.add(orders.get(order));
            }
        }

        return headers;
    }

    private Map<Integer, String> getHeaderMap(Row titleRow, Class clz) {
        List<ExcelHeader> headers = this.getHeaderList(clz);
        Map<Integer, String> maps = new HashMap();
        Iterator var5 = titleRow.iterator();

        while (true) {
            while (var5.hasNext()) {
                Cell c = (Cell) var5.next();
                String title = c.getStringCellValue();
                Iterator var8 = headers.iterator();

                while (var8.hasNext()) {
                    ExcelHeader eh = (ExcelHeader) var8.next();
                    if (eh.getTitle().equals(title.trim())) {
                        maps.put(c.getColumnIndex(), eh.getMethodName().replaceFirst("get", "set"));
                        break;
                    }
                }
            }

            return maps;
        }
    }

    private List<Map<String, Object>> objs2Map(List objs, List<ExcelHeader> headers) {
        ArrayList infos = new ArrayList();

        try {
            Iterator var4 = objs.iterator();

            while (var4.hasNext()) {
                Object obj = var4.next();
                Map<String, Object> info = new HashMap();
                Iterator var7 = headers.iterator();

                while (var7.hasNext()) {
                    ExcelHeader eh = (ExcelHeader) var7.next();
                    Object val = BeanUtils.getProperty(obj, this.getMethodName(eh));
                    info.put(eh.getMethodName(), val);
                }

                infos.add(info);
            }
        } catch (IllegalAccessException var10) {
            var10.printStackTrace();
        } catch (InvocationTargetException var11) {
            var11.printStackTrace();
        } catch (NoSuchMethodException var12) {
            var12.printStackTrace();
        }

        return infos;
    }

    private Object convertForCopy(final Object value, final Class<?> type) {
        return (value != null) ? convert(value, type) : value;
    }

    protected Object convert(final Object value, final Class<?> type) {
        final Converter converter = getConvertUtils().lookup(type);
        if (converter != null) {
            return converter.convert(type, value);
        } else {
            return value;
        }
    }

    public ConvertUtilsBean getConvertUtils() {
        return convertUtilsBean;
    }

    /*
     * 判断是否为浮点型
     * @param str 传入的字符串
     * @return 是浮点型（包含小数）返回true,否则返回false
     */
    public static boolean isDouble(String str){
        if (StringUtils.isEmpty(str)){
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        //判断是否有小数点
        if(str.indexOf(".")>0){
            if(str.indexOf(".")==str.lastIndexOf(".") && str.split("\\.").length==2){ //判断是否只有一个小数点
                return pattern.matcher(str.replace(".","")).matches();
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}



