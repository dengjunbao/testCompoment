package com.component.ExcelUtils.excel;

import com.component.test.ExcelUtils.annotation.ExcelResources;
import com.component.test.ExcelUtils.componemet.IExcelComponent;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 15:17
 */
@Component
public class ExcelComponent implements IExcelComponent {
    private List<Integer> exceptOrder;

    public ExcelComponent() {
    }

    private ExcelTemplate handlerObj2Excel(String template, List objs, Class clz, boolean isClasspath) {
        ExcelTemplate et = ExcelTemplate.getInstance();
        if (isClasspath) {
            et.readTemplateByClasspath(template);
        } else {
            et.readTemplateByPath(template);
        }

        List<ExcelHeader> headers = this.getHeaderList(clz);
        Collections.sort(headers);
        List<Map<String, Object>> infos = this.objs2Map(objs, headers);
        et.setDataHead(headers);

        try {
            Iterator var8 = objs.iterator();

            while(var8.hasNext()) {
                Object obj = var8.next();
                et.createNewRow();
                Iterator var10 = headers.iterator();

                while(var10.hasNext()) {
                    ExcelHeader eh = (ExcelHeader)var10.next();
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
        if (null != datas && StringUtils.isNotBlank((String)datas.get("-exceptOrder-"))) {
            this.exceptOrder = new ArrayList();
            String[] arr = StringUtils.split((String)datas.get("-exceptOrder-"), ",");
            String[] var3 = arr;
            int var4 = arr.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String order = var3[var5];
                this.exceptOrder.add(Integer.parseInt(order));
            }

            datas.remove("-exceptOrder-");
        } else {
            this.exceptOrder = null;
        }

    }

    public void exportByTemplate(Map<String, String> datas, String template, OutputStream os, List objs, Class clz, boolean isClasspath) {
        this.handelExceptOrder(datas);

        try {
            ExcelTemplate et = this.handlerObj2Excel(template, objs, clz, isClasspath);
            et.replaceFinalData(datas);
            et.wirteToStream(os);
            os.flush();
            os.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }

    public void exportByTemplate(Map<String, String> datas, String template, String outPath, List objs, Class clz, boolean isClasspath) {
        this.handelExceptOrder(datas);
        ExcelTemplate et = this.handlerObj2Excel(template, objs, clz, isClasspath);
        et.replaceFinalData(datas);
        et.writeToFile(outPath);
    }

    public void exportByTemplate(Properties prop, String template, OutputStream os, List objs, Class clz, boolean isClasspath) {
        ExcelTemplate et = this.handlerObj2Excel(template, objs, clz, isClasspath);
        et.replaceFinalData(prop);
        et.wirteToStream(os);
    }

    public void exportByTemplate(Properties prop, String template, String outPath, List objs, Class clz, boolean isClasspath) {
        ExcelTemplate et = this.handlerObj2Excel(template, objs, clz, isClasspath);
        et.replaceFinalData(prop);
        et.writeToFile(outPath);
    }

    private Workbook handleObj2Excel(List objs, Class clz) {
        HSSFWorkbook wb = new HSSFWorkbook();

        try {
            Sheet sheet = wb.createSheet();
            Row r = sheet.createRow(0);
            List<ExcelHeader> headers = this.getHeaderList(clz);
            Collections.sort(headers);

            for(int i = 0; i < headers.size(); ++i) {
                r.createCell(i).setCellValue(((ExcelHeader)headers.get(i)).getTitle());
            }

            Object obj = null;

            for(int i = 0; i < objs.size(); ++i) {
                r = sheet.createRow(i + 1);
                obj = objs.get(i);

                for(int j = 0; j < headers.size(); ++j) {
                    r.createCell(j).setCellValue(BeanUtils.getProperty(obj, this.getMethodName((ExcelHeader)headers.get(j))));
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

    public void export(OutputStream os, List objs, Class clz) {
        try {
            Workbook wb = this.handleObj2Excel(objs, clz);
            wb.write(os);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public List<Object> readByClasspath(String path, Class clz, int readLine, int tailLine) {
        Object wb = null;

        try {
            if (path.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(new FileInputStream(path));
            } else {
                wb = new HSSFWorkbook(TemplateFileUtil.getTemplates(path));
            }

            return this.handlerExcel2Objs((Workbook)wb, clz, readLine, tailLine);
        } catch (IOException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public List<Object> readByBytes(byte[] bytes, Boolean isXlsx, Class clz, int readLine, int tailLine) {
        Object wb = null;

        try {
            if (isXlsx) {
                wb = new XSSFWorkbook(new ByteArrayInputStream(bytes));
            } else {
                wb = new HSSFWorkbook(new ByteArrayInputStream(bytes));
            }

            return this.handlerExcel2Objs((Workbook)wb, clz, readLine, tailLine);
        } catch (IOException var8) {
            var8.printStackTrace();
            return null;
        }
    }

    public List<Object> readByPath(String path, Class clz, int readLine, int tailLine) {
        Object wb = null;

        try {
            if (path.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(new FileInputStream(path));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(path));
            }

            return this.handlerExcel2Objs((Workbook)wb, clz, readLine, tailLine);
        } catch (IOException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public List<Object> readByClasspath(String path, Class clz) {
        return this.readByClasspath(path, clz, 0, 0);
    }

    public List<Object> readByPath(String path, Class clz) {
        return this.readByPath(path, clz, 0, 0);
    }

    private String getCellValue(Cell c) {
        String o = null;
        switch(c.getCellType().getCode()) {
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

    private List<Object> handlerExcel2Objs(Workbook wb, Class clz, int readLine, int tailLine) {
        Sheet sheet = wb.getSheetAt(0);
        ArrayList objs = null;

        try {
            Row row = sheet.getRow(readLine);
            objs = new ArrayList();
            Map<Integer, String> maps = this.getHeaderMap(row, clz);
            if (maps == null || maps.size() <= 0) {
                throw new RuntimeException("要读取的Excel的格式不正确，检查是否设定了合适的行");
            }

            for(int i = readLine + 1; i <= sheet.getLastRowNum() - tailLine; ++i) {
                row = sheet.getRow(i);
                if (null != row) {
                    Object obj = clz.newInstance();
                    Boolean isNull = false;
                    Iterator var12 = row.iterator();

                    while(var12.hasNext()) {
                        Cell c = (Cell)var12.next();
                        if (null == c) {
                            isNull = true;
                            break;
                        }

                        int ci = c.getColumnIndex();
                        if (maps.containsKey(ci)) {
                            String mn = ((String)maps.get(ci)).substring(3);
                            mn = mn.substring(0, 1).toLowerCase() + mn.substring(1);
                            BeanUtils.copyProperty(obj, mn, this.getCellValue(c));
                        }
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

    private List<ExcelHeader> getHeaderList(Class clz) {
        List<ExcelHeader> headers = new ArrayList();
        Map<Integer, ExcelHeader> orders = new HashMap();
        Method[] ms = clz.getDeclaredMethods();
        Method[] var5 = ms;
        int var6 = ms.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Method m = var5[var7];
            String mn = m.getName();
            if (mn.startsWith("get") && m.isAnnotationPresent(ExcelResources.class)) {
                ExcelResources er = (ExcelResources)m.getAnnotation(ExcelResources.class);
                orders.put(er.order(), new ExcelHeader(er.title(), er.order(), er.width(), mn));
            }
        }

        List orderList = Arrays.asList(orders.keySet());
        Integer[] arr = (Integer[])orders.keySet().toArray(new Integer[orderList.size()]);
        Arrays.sort(arr);
        Integer[] var13 = arr;
        int var14 = arr.length;

        for(int var15 = 0; var15 < var14; ++var15) {
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

        while(true) {
            while(var5.hasNext()) {
                Cell c = (Cell)var5.next();
                String title = c.getStringCellValue();
                Iterator var8 = headers.iterator();

                while(var8.hasNext()) {
                    ExcelHeader eh = (ExcelHeader)var8.next();
                    if (eh.getTitle().equals(title.trim())) {
                        maps.put(c.getColumnIndex(), eh.getMethodName().replace("get", "set"));
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

            while(var4.hasNext()) {
                Object obj = var4.next();
                Map<String, Object> info = new HashMap();
                Iterator var7 = headers.iterator();

                while(var7.hasNext()) {
                    ExcelHeader eh = (ExcelHeader)var7.next();
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
}
