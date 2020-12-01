package com.component.ExcelUtils.excel;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 15:23
 */
public class ExcelHeader implements Comparable<ExcelHeader> {
    private String title;
    private int order;
    private int width;
    private String methodName;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int compareTo(ExcelHeader o) {
        return this.order > o.order ? 1 : (this.order < o.order ? -1 : 0);
    }

    public ExcelHeader(String title, int order, int width, String methodName) {
        this.title = title;
        this.order = order;
        this.width = width;
        this.methodName = methodName;
    }

    public String toString() {
        return "ExcelHeader [title=" + this.title + ", order=" + this.order + ", methodName=" + this.methodName + "]";
    }
}

