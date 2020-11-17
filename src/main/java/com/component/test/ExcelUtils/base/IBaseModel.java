package com.component.test.ExcelUtils.base;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:29
 */
public interface IBaseModel {
    Integer getId();

    Integer getCreatedby();

    void setCreatedby(Integer var1);

    Integer getCreatedat();

    void setCreatedat(Integer var1);

    Integer getUpdatedby();

    void setUpdatedby(Integer var1);

    Integer getUpdatedat();

    void setUpdatedat(Integer var1);

    Boolean getIslogicdel();

    void setIslogicdel(Boolean var1);
}
