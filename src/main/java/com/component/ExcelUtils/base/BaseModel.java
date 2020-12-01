package com.component.ExcelUtils.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:29
 */
public abstract class BaseModel implements IBaseModel, Serializable {
    private static final long serialVersionUID = 1L;

    public BaseModel() {
    }

    public Integer getId() {
        return null;
    }

    public Integer getCreatedby() {
        return null;
    }

    public void setCreatedby(Integer createdby) {
    }

    public Integer getCreatedat() {
        return null;
    }

    public void setCreatedat(Integer createdat) {
    }

    public Integer getUpdatedby() {
        return null;
    }

    public void setUpdatedby(Integer updatedby) {
    }

    public Integer getUpdatedat() {
        return null;
    }

    public void setUpdatedat(Integer updatedat) {
    }

    @JsonIgnore
    public Boolean getIslogicdel() {
        return null;
    }

    public void setIslogicdel(Boolean islogicdel) {
    }
}

