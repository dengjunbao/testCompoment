package com.component.ExcelUtils.componemet;

import com.component.ExcelUtils.base.IBaseComponent;
import com.component.test.ExcelUtils.base.IBaseComponent;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:47
 */
public interface IResourceComponent extends IBaseComponent {
    String getTpl(String var1, String var2);

    String getLan(String var1, String var2);

    String getImg(String var1, String var2);

    String getCnf(String var1, String var2);
}
