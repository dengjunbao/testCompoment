package com.component.ExcelUtils.excel;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.StringUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 15:19
 */
public class ExcelTemplate {
    public static final String HEAD_LINE = "{head}";
    public static final String DATA_LINE = "{datas}";
    public static final String MERGE_ROW = "{mergeRow}";
    public static final String MERGE_TOP = "{mergeTop}";
    public static final String MERGE_LEFT = "{mergeLeft}";
    public static final String DEFAULT_STYLE = "{defaultStyles}";
    public static final String STYLE = "{styles}";
    public static final String SER_NUM = "{sernums}";
    private Workbook wb;
    private Sheet sheet;
    private int initHeadColIndex = -1;
    private int initHeadRowIndex = -1;
    private CellStyle headStyle;
    private int initColIndex;
    private int initRowIndex;
    private int curColIndex;
    private int curRowIndex;
    private Row curRow;
    private int lastRowIndex;
    private CellStyle defaultStyle;
    private float rowHeight;
    private Map<Integer, CellStyle> styles;
    private int serColIndex;
    private Map<Integer, CellStyle> mergeRows;

    private ExcelTemplate() {
    }

    public static ExcelTemplate getInstance() {
        return new ExcelTemplate();
    }

    public ExcelTemplate readTemplateByClasspath(String path) {
        try {
            this.wb = new HSSFWorkbook(TemplateFileUtil.getTemplates(path));
            this.initTemplate();
            return this;
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException("读取模板不存在！请检查");
        }
    }

    public ExcelTemplate readTemplateByPath(String path) {
        try {
            this.wb = new HSSFWorkbook(new FileInputStream(path));
            this.initTemplate();
            return this;
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException("读取模板不存在！请检查");
        }
    }

    public void writeToFile(String filepath) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(filepath);
            this.wb.write(fos);
        } catch (FileNotFoundException var12) {
            var12.printStackTrace();
            throw new RuntimeException("写入的文件不存在");
        } catch (IOException var13) {
            var13.printStackTrace();
            throw new RuntimeException("写入数据失败:" + var13.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException var11) {
                var11.printStackTrace();
            }

        }

    }

    public void wirteToStream(OutputStream os) {
        try {
            this.wb.write(os);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException("写入流失败:" + var3.getMessage());
        }
    }

    public void setMergedRegion(List<Map<String, Object>> infos, List<ExcelHeader> headers) {
        Map<String, String> info = new HashMap();
        Map<String, String> temp = new HashMap();
        Integer row = this.initRowIndex;
        String k = "";
        String v = "";
        Iterator var8;
        if (this.mergeRows != null && this.mergeRows.size() > 0) {
            var8 = this.mergeRows.keySet().iterator();

            label98:
            while(true) {
                Integer mergeRow;
                do {
                    do {
                        if (!var8.hasNext()) {
                            break label98;
                        }

                        mergeRow = (Integer)var8.next();
                        if (mergeRow < row) {
                            k = String.format("%s,%s", mergeRow, this.initColIndex);
                            v = String.format("%s,%s", mergeRow, headers.size() - 1);
                        } else if (mergeRow > row) {
                            k = String.format("%s,%s", mergeRow + infos.size(), this.initColIndex);
                            v = String.format("%s,%s", mergeRow + infos.size(), headers.size());
                        }
                    } while(ObjectUtils.isEmpty(k));
                } while(ObjectUtils.isEmpty(v));

                Row r = this.sheet.getRow(mergeRow);

                for(int i = this.initColIndex; i <= headers.size() - 1; ++i) {
                    Cell c = r.getCell(i);
                    if (c == null) {
                        c = r.createCell(i);
                    }

                    c.setCellStyle((CellStyle)this.mergeRows.get(mergeRow));
                }

                info.put(k, v);
            }
        }

        for(var8 = infos.iterator(); var8.hasNext(); row = row + 1) {
            Map<String, Object> item = (Map)var8.next();
            Integer col = this.initColIndex;

            for(Iterator var20 = headers.iterator(); var20.hasNext(); col = col + 1) {
                ExcelHeader eh = (ExcelHeader)var20.next();
                Object val = item.get(eh.getMethodName());
                if (null != val) {
                    k = "";
                    v = "";
                    if ("{mergeTop}".equals(val.toString()) && row - 1 >= 0) {
                        k = String.format("%s,%s", row - 1, col);
                        v = String.format("%s,%s", row, col);
                    } else if ("{mergeLeft}".equals(val.toString()) && col - 1 >= 0) {
                        k = String.format("%s,%s", row, col - 1);
                        v = String.format("%s,%s", row, col);
                    }

                    if (!ObjectUtils.isEmpty(k) && !ObjectUtils.isEmpty(v)) {
                        if (info.containsValue(k)) {
                            k = (String)temp.get(k);
                        }

                        info.put(k, v);
                        temp.put(v, k);
                    }
                }
            }
        }

        if (info.size() > 0) {
            var8 = info.keySet().iterator();

            while(var8.hasNext()) {
                String key = (String)var8.next();
                String[] arrKey = StringUtils.split(key, ",");
                String[] arrVal = StringUtils.split((String)info.get(key), ",");
                this.sheet.addMergedRegion(new CellRangeAddress(Integer.parseInt(arrKey[0]), Integer.parseInt(arrVal[0]), Integer.parseInt(arrKey[1]), Integer.parseInt(arrVal[1])));
            }
        }

    }

    public void setRowWidth(List<ExcelHeader> headers) {
        Integer col = this.initColIndex;

        for(Iterator var3 = headers.iterator(); var3.hasNext(); col = col + 1) {
            ExcelHeader eh = (ExcelHeader)var3.next();
            if (eh.getWidth() > 0) {
                this.sheet.setColumnWidth(col, eh.getWidth() * 256);
            }
        }

    }

    public void setDataHead(List<ExcelHeader> headers) {
        if (this.initHeadRowIndex >= 0) {
            Row row = this.sheet.getRow(this.initHeadRowIndex);
            Integer colIndex = this.initHeadColIndex;

            for(Iterator var4 = headers.iterator(); var4.hasNext(); colIndex = colIndex + 1) {
                ExcelHeader eh = (ExcelHeader)var4.next();
                Cell c = row.getCell(colIndex);
                if (c == null) {
                    c = row.createCell(colIndex);
                }

                c.setCellValue(eh.getTitle());
                c.setCellStyle(this.headStyle);
            }
        }

    }

    public Boolean checkValue(Object val) {
        return null != val && !"{mergeTop}".equals(val.toString()) && !"{mergeLeft}".equals(val.toString()) ? true : false;
    }

    public void createCell(String value) {
        Cell c = this.curRow.createCell(this.curColIndex);
        this.setCellStyle(c);
        if (this.checkValue(value)) {
            c.setCellValue(value);
        }

        ++this.curColIndex;
    }

    public void createCell(int value) {
        Cell c = this.curRow.createCell(this.curColIndex);
        this.setCellStyle(c);
        if (this.checkValue(value)) {
            c.setCellValue((double)value);
        }

        ++this.curColIndex;
    }

    public void createCell(Date value) {
        Cell c = this.curRow.createCell(this.curColIndex);
        this.setCellStyle(c);
        if (this.checkValue(value)) {
            c.setCellValue(value);
        }

        ++this.curColIndex;
    }

    public void createCell(double value) {
        Cell c = this.curRow.createCell(this.curColIndex);
        this.setCellStyle(c);
        if (this.checkValue(value)) {
            c.setCellValue(value);
        }

        ++this.curColIndex;
    }

    public void createCell(boolean value) {
        Cell c = this.curRow.createCell(this.curColIndex);
        this.setCellStyle(c);
        if (this.checkValue(value)) {
            c.setCellValue(value);
        }

        ++this.curColIndex;
    }

    public void createCell(Calendar value) {
        Cell c = this.curRow.createCell(this.curColIndex);
        this.setCellStyle(c);
        if (this.checkValue(value)) {
            c.setCellValue(value);
        }

        ++this.curColIndex;
    }

    public void createCell(BigInteger value) {
        Cell c = this.curRow.createCell(this.curColIndex);
        this.setCellStyle(c);
        if (this.checkValue(value)) {
            c.setCellValue(value == null ? 0.0D : (double)value.intValue());
        }

        ++this.curColIndex;
    }

    private void setCellStyle(Cell c) {
        if (this.styles.containsKey(this.curColIndex)) {
            c.setCellStyle((CellStyle)this.styles.get(this.curColIndex));
        } else {
            c.setCellStyle(this.defaultStyle);
        }

    }

    public void createNewRow() {
        if (this.lastRowIndex > this.curRowIndex && this.curRowIndex != this.initRowIndex) {
            this.sheet.shiftRows(this.curRowIndex, this.lastRowIndex, 1, true, true);
            ++this.lastRowIndex;
        }

        this.curRow = this.sheet.createRow(this.curRowIndex);
        this.curRow.setHeightInPoints(this.rowHeight);
        ++this.curRowIndex;
        this.curColIndex = this.initColIndex;
    }

    public void insertSer() {
        int index = 1;
        Row row = null;
        Cell c = null;

        for(int i = this.initRowIndex; i < this.curRowIndex; ++i) {
            row = this.sheet.getRow(i);
            c = row.createCell(this.serColIndex);
            this.setCellStyle(c);
            c.setCellValue((double)(index++));
        }

    }

    public void replaceFinalData(Map<String, String> datas) {
        if (datas != null) {
            Iterator var2 = this.sheet.iterator();

            while(var2.hasNext()) {
                Row row = (Row)var2.next();
                Iterator var4 = row.iterator();

                while(var4.hasNext()) {
                    Cell c = (Cell)var4.next();
                    String str = c.getStringCellValue().trim();
                    if (str.startsWith("#") && datas.containsKey(str.substring(1))) {
                        c.setCellValue((String)datas.get(str.substring(1)));
                    }
                }
            }

        }
    }

    public void replaceFinalData(Properties prop) {
        if (prop != null) {
            Iterator var2 = this.sheet.iterator();

            while(var2.hasNext()) {
                Row row = (Row)var2.next();
                Iterator var4 = row.iterator();

                while(var4.hasNext()) {
                    Cell c = (Cell)var4.next();
                    String str = c.getStringCellValue().trim();
                    if (str.startsWith("#") && prop.containsKey(str.substring(1))) {
                        c.setCellValue(prop.getProperty(str.substring(1)));
                    }
                }
            }

        }
    }

    private void initTemplate() {
        this.sheet = this.wb.getSheetAt(0);
        this.initConfigData();
        this.lastRowIndex = this.sheet.getLastRowNum();
        this.curRow = this.sheet.createRow(this.curRowIndex);
    }

    private void initConfigData() {
        boolean findData = false;
        boolean findSer = false;
        Iterator var3 = this.sheet.iterator();

        while(var3.hasNext()) {
            Row row = (Row)var3.next();
            if (findData) {
                break;
            }

            Iterator var5 = row.iterator();

            while(var5.hasNext()) {
                Cell c = (Cell)var5.next();
                String str = c.getStringCellValue().trim();
                if (str.equals("{sernums}")) {
                    this.serColIndex = c.getColumnIndex();
                    findSer = true;
                }

                if (str.equals("{head}")) {
                    this.initHeadColIndex = c.getColumnIndex();
                    this.initHeadRowIndex = row.getRowNum();
                    this.headStyle = c.getCellStyle();
                }

                if (str.equals("{datas}")) {
                    this.initColIndex = c.getColumnIndex();
                    this.initRowIndex = row.getRowNum();
                    this.curColIndex = this.initColIndex;
                    this.curRowIndex = this.initRowIndex;
                    findData = true;
                    this.defaultStyle = c.getCellStyle();
                    this.rowHeight = row.getHeightInPoints();
                    this.initStyles();
                    break;
                }
            }
        }

        if (!findSer) {
            this.initSer();
        }

    }

    private void initSer() {
        Iterator var1 = this.sheet.iterator();

        while(var1.hasNext()) {
            Row row = (Row)var1.next();
            Iterator var3 = row.iterator();

            while(var3.hasNext()) {
                Cell c = (Cell)var3.next();
                String str = c.getStringCellValue().trim();
                if (str.equals("{sernums}")) {
                    this.serColIndex = c.getColumnIndex();
                }
            }
        }

    }

    private void initStyles() {
        this.styles = new HashMap();
        Iterator var1 = this.sheet.iterator();

        while(var1.hasNext()) {
            Row row = (Row)var1.next();
            Iterator var3 = row.iterator();

            while(var3.hasNext()) {
                Cell c = (Cell)var3.next();
                String str = c.getStringCellValue().trim();
                if (str.equals("{defaultStyles}")) {
                    this.defaultStyle = c.getCellStyle();
                }

                if (str.equals("{styles}")) {
                    this.styles.put(c.getColumnIndex(), c.getCellStyle());
                }

                if (str.equals("{mergeRow}")) {
                    if (this.mergeRows == null) {
                        this.mergeRows = new HashMap();
                    }

                    this.mergeRows.put(c.getRowIndex(), c.getCellStyle());
                }
            }
        }

    }

    public Sheet copycols(int startCol, int endCol, int pPosition) {
        int pStartCol = startCol - 1;
        int pEndCol = endCol - 1;
        CellRangeAddress region = null;
        if (pStartCol != -1 && pEndCol != -1) {
            System.out.println(this.sheet.getNumMergedRegions());

            int i;
            for(i = 0; i < this.sheet.getNumMergedRegions(); ++i) {
                region = this.sheet.getMergedRegion(i);
                if (region.getFirstColumn() >= pStartCol && region.getLastColumn() <= pEndCol) {
                    int targetColFrom = region.getFirstColumn() - pStartCol + pPosition;
                    int targetColTo = region.getLastColumn() - pStartCol + pPosition;
                    CellRangeAddress newRegion = region.copy();
                    newRegion.setFirstRow(region.getFirstRow());
                    newRegion.setFirstColumn(targetColFrom);
                    newRegion.setLastRow(region.getLastRow());
                    newRegion.setLastColumn(targetColTo);
                    this.sheet.addMergedRegion(newRegion);
                }
            }

            for(i = 0; i <= 50; ++i) {
                Row sourceRow = this.sheet.getRow(i);
                if (sourceRow != null) {
                    Row newRow = this.sheet.getRow(i);

                    for(int j = 0; j < pEndCol; ++j) {
                        Cell templateCell = sourceRow.getCell(j);
                        if (i == 0) {
                            this.sheet.setColumnWidth(pPosition + j, this.sheet.getColumnWidth(j));
                        }

                        if (templateCell != null) {
                            Cell newCell = newRow.createCell(pPosition + j);
                            this.copyCell(templateCell, newCell);
                        }
                    }
                }
            }

            return this.sheet;
        } else {
            return null;
        }
    }

    public void copyRows(int startRow, int endRow, int pPosition) {
        int pStartRow = startRow - 1;
        int pEndRow = endRow - 1;
        CellRangeAddress region = null;
        if (pStartRow != -1 && pEndRow != -1) {
            int i;
            for(i = 0; i < this.sheet.getNumMergedRegions(); ++i) {
                region = this.sheet.getMergedRegion(i);
                if (region.getFirstRow() >= pStartRow && region.getLastRow() <= pEndRow) {
                    int targetRowFrom = region.getFirstRow() - pStartRow + pPosition;
                    int targetRowTo = region.getLastRow() - pStartRow + pPosition;
                    CellRangeAddress newRegion = region.copy();
                    newRegion.setFirstRow(targetRowFrom);
                    newRegion.setFirstColumn(region.getFirstColumn());
                    newRegion.setLastRow(targetRowTo);
                    newRegion.setLastColumn(region.getLastColumn());
                    this.sheet.addMergedRegion(newRegion);
                }
            }

            for(i = pStartRow; i <= pEndRow; ++i) {
                Row sourceRow = this.sheet.getRow(i);
                int columnCount = sourceRow.getLastCellNum();
                if (sourceRow != null) {
                    Row newRow = this.sheet.createRow(pPosition - pStartRow + i);
                    newRow.setHeight(sourceRow.getHeight());

                    for(int j = 0; j < columnCount; ++j) {
                        Cell templateCell = sourceRow.getCell(j);
                        if (templateCell != null) {
                            Cell newCell = newRow.createCell(j);
                            this.copyCell(templateCell, newCell);
                        }
                    }
                }
            }

        }
    }

    private void copyCell(Cell srcCell, Cell distCell) {
        distCell.setCellStyle(srcCell.getCellStyle());
        if (srcCell.getCellComment() != null) {
            distCell.setCellComment(srcCell.getCellComment());
        }

        CellType srcCellType = CellType.forInt(srcCell.getCellType());
        distCell.setCellType(srcCellType);
        if (srcCellType.getCode() == 0) {
            if (HSSFDateUtil.isCellDateFormatted(srcCell)) {
                distCell.setCellValue(srcCell.getDateCellValue());
            } else {
                distCell.setCellValue(srcCell.getNumericCellValue());
            }
        } else if (srcCellType.getCode() == 1) {
            distCell.setCellValue(srcCell.getRichStringCellValue());
        } else if (srcCellType.getCode() != 3) {
            if (srcCellType.getCode() == 4) {
                distCell.setCellValue(srcCell.getBooleanCellValue());
            } else if (srcCellType.getCode() == 5) {
                distCell.setCellErrorValue(srcCell.getErrorCellValue());
            } else if (srcCellType.getCode() == 2) {
                distCell.setCellFormula(srcCell.getCellFormula());
            }
        }

    }
}
