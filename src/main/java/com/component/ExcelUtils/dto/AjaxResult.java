package com.component.ExcelUtils.dto;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:41
 */
public class AjaxResult extends ApiResult {
    private String backurl = null;

    public String getBackurl() {
        return this.backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }

    public AjaxResult(int status, String message, Object data) {
        super(status, message, data);
    }

    public AjaxResult(int status, String message) {
        super(status, message);
    }

    public AjaxResult(Object data) {
        super(data);
    }

    public AjaxResult(int status) {
        super(status);
    }

    public AjaxResult(String message) {
        super(message);
    }

    public AjaxResult() {
    }

    public String toString() {
        return "AjaxResult [status=" + this.getStatus() + ", message=" + this.getMessage() + ", data=" + this.getData() + "]";
    }
}
