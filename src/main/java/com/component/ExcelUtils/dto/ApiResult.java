package com.component.ExcelUtils.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:41
 */
public class ApiResult implements Serializable {
    private int status = 200;
    private String message = "操作成功";
    private Map<String, Object> params = null;
    private Object data;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResult(Object data) {
        this.message = "查询成功";
        this.data = data;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public ApiResult(int status) {
        this.status = status;
        this.message = "操作失败";
    }

    public ApiResult(String message) {
        this.status = 0;
        this.message = message;
    }

    public ApiResult() {
    }
}

