package com.component.test.ExcelUtils.common;

import com.component.test.ExcelUtils.utils.ComUtils;
import com.component.test.ExcelUtils.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class ExcelUitlsTo extends ExcelUtil {

    private static ExcelUtilsExtend component;

    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private static String errorMsg;

    //获取总行数
    public int getTotalRows()  { return totalRows;}
    //获取总列数
    public int getTotalCells() {  return totalCells;}
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }


    public static Boolean isExists() {
        if (component == null) {
            //这里修改成单一对象，而不是接口。接口的话无法修改其方法
            component = new ExcelUtilsExtend();
        }

        return null != component;
    }

    public static void exportByTmpl(Map<String, String> datas, String template, OutputStream os, List objs, Class clz, boolean isClasspath,List<Integer> ids) {
        if (isExists()) {
            //exportByTemplateBo
            component.exportByTemplateBo(datas, template, os, objs, clz, isClasspath,ids);
        }

    }

    public static void downByTmpl(Map<String, String> datas, String template, String fileName, List objs, Class clz, boolean isClasspath,List<Integer> ids) {
        HttpServletResponse response = ComUtils.getResponse();
        response.setHeader("content-Type", "application/vnd.ms-excel");

        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
        } catch (UnsupportedEncodingException var9) {
            //LoggerUtils.error(var9.getMessage(), var9);
        }

        response.setCharacterEncoding("UTF-8");

        try {
            exportByTmpl(datas, template, (OutputStream)response.getOutputStream(), objs, clz, isClasspath,ids);
        } catch (Exception var8) {
            //LoggerUtils.error(var8.getMessage(), var8);
        }

    }

    public Integer Add(String path){

        return 1;
    }
    public static Integer getExcelInfo( String path) {
        File file = new File("C:\\Users\\gwq\\Desktop\\物业租赁管理台账表(3月).xlsx");
        String fileName = file.getName();//获取文件名
        System.out.println("文件名"+fileName);
        InputStream inputStream = null;
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            // 创建字节输入流
            inputStream = new FileInputStream(file);
            createExcel(inputStream, isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

//    public static void  main(String[] args){
//        getExcelInfo("");
//    }
 public static Integer createExcel(InputStream is, boolean isExcel2003) {

        try{
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(is);
            }
            String a="52";
            System.out.println(a);
            //stuList = readExcelValue(wb);// 读取Excel里面客户的信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }
    /* *//**
     * 读取Excel里面客户的信息
     * @param wb
     * @return
     *//*
    private List<Student> readExcelValue(Workbook wb) {
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        System.out.println("gaolei dayin============" +sheet);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("行数======="+this.totalRows);
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("总列数=========="+this.totalCells);
        }
        List<Student> stuList = new ArrayList<Student>();
        // 循环Excel行数
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            Student student = new Student();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {

                    if (c == 0) {
                        //如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            try {
                                //String studentNumber = String.valueOf(cell.getNumericCellValue());
                                //String x =studentNumber.substring(0, studentNumber.length()-2>0?studentNumber.length()-2:1);//年龄
                                student.setStudentnumber(Integer.valueOf((int) cell.getNumericCellValue()));
                            } catch (NumberFormatException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                                System.out.println("if false");
                            }
                        }else{
                            try {
                                student.setStudentnumber(Integer.valueOf(cell.getStringCellValue()));
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                                System.out.println("类型不匹配");
                            }
                        }
                    } else if (c == 1) {
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String appUserId = String.valueOf(cell.getNumericCellValue());
                            String x = appUserId.substring(0, appUserId.length()-2>0?appUserId.length()-2:1);//性别
                            student.setAppuserid(Long.valueOf(x));
                        }
                    }
                    else if (c == 2){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String firstName = String.valueOf(cell.getNumericCellValue());
                            student.setFirstname(firstName);
                        }else{
                            student.setFirstname(cell.getStringCellValue());
                        }
                    }
                    else if (c == 3){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String middleName = String.valueOf(cell.getNumericCellValue());
                            student.setMiddlename(middleName);
                        }else{
                            student.setMiddlename(cell.getStringCellValue());
                        }
                    }
                    else if (c == 4){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String lastName = String.valueOf(cell.getNumericCellValue());
                            student.setLastname(lastName);
                        }else{
                            student.setLastname(cell.getStringCellValue());
                        }
                    }
                    else if (c == 5){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String email = String.valueOf(cell.getNumericCellValue());
                            student.setEmail(email);
                        }else{
                            student.setEmail(cell.getStringCellValue());
                        }
                    }
                    else if (c == 6){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            Integer classNumber = Integer.valueOf((int) cell.getNumericCellValue());
                            //student.setClassnumber(classNumber.substring(0, classNumber.length()-2>0?classNumber.length()-2:1));
                            System.out.println("if classnum");
                            student.setClassnumber(String.valueOf(classNumber));
                        }else{
                            student.setClassnumber(cell.getStringCellValue());
                            System.out.println("else classnum");
                        }
                    }
                    else if (c == 7){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String gender = String.valueOf(cell.getNumericCellValue());
                            student.setGender(gender);
                        }else{
                            student.setGender(cell.getStringCellValue());
                        }
                    }
                    else if (c == 8){

                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String status = String.valueOf(cell.getNumericCellValue());
                            student.setStatus(status);
                        }else{
                            student.setStatus(cell.getStringCellValue());
                        }
                    }
                }
            }
            // 添加到list
            stuList.add(student);
        }
        return stuList;
    }*/

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public static  boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }
    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

}
