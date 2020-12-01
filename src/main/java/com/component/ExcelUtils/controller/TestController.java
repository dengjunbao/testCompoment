package com.component.ExcelUtils.controller;

import com.component.ExcelUtils.base.BaseController;
import com.component.ExcelUtils.bo.SpmPropertyBo;
import com.component.ExcelUtils.dto.SpmPropertyDto;
import com.component.test.ExcelUtils.base.BaseController;
import com.component.test.ExcelUtils.bo.SpmPropertyBo;
import com.component.test.ExcelUtils.common.ExcelUitlsTo;
import com.component.test.ExcelUtils.dto.SpmPropertyDto;
import com.component.test.ExcelUtils.utils.ComUtils;
import com.component.test.ExcelUtils.utils.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:38
 */
@Controller
@RequestMapping("/property")
public class TestController extends BaseController {

    @RequestMapping("/export")
    @ResponseBody
    public void export() {
        SpmPropertyBo spmPropertyBo = new SpmPropertyBo();
        SpmPropertyBo spmPropertyBo2 = new SpmPropertyBo();
        List<SpmPropertyBo> rows = new ArrayList<>();
        List dtos = new ArrayList();
        List<Integer> ids = new ArrayList<>();

        spmPropertyBo.setProno("2020【A】0018");
        spmPropertyBo.setPoname("珠海市某某单位");
        spmPropertyBo.setManageTypeName("自有");
        spmPropertyBo.setProidentityno("无证");
        spmPropertyBo.setProarea(new BigDecimal(200));
        spmPropertyBo.setUnitpricepersm(new BigDecimal(5));
        spmPropertyBo.setUnitprice(new BigDecimal(2000));

        spmPropertyBo2.setProno("2020【A】0019");
        spmPropertyBo2.setPoname("肇庆某某单位");
        spmPropertyBo2.setManageTypeName("自有");
        spmPropertyBo2.setProidentityno("FC-6496294");
        spmPropertyBo2.setProarea(new BigDecimal(100));
        spmPropertyBo2.setUnitpricepersm(new BigDecimal(10));
        spmPropertyBo2.setUnitprice(new BigDecimal(2000));

        rows.add(spmPropertyBo);    //todo 模拟数据
        rows.add(spmPropertyBo2);
        Collections.reverse(rows); // 倒序排列

        ids.add(6);//todo 模拟数据 不需要的字段 对应DTO类的Order
        ids.add(7);
        ids.add(10);
        ids.add(11);
        ids.add(12);


        Class clazz = null;
        clazz = SpmPropertyDto.class;
        SpmPropertyDto spmPropertyDto = null;
        if (null != rows && rows.size() > 0) {
            for (int i = 1; i < rows.size() + 1; i++) {
                spmPropertyDto = ComUtils.object2Bean(rows.get(i - 1), SpmPropertyDto.class);
                spmPropertyDto.setId(i);
                dtos.add(spmPropertyDto);
            }
        }

        Map<String, String> mapa = new HashMap<String, String>();
        mapa.put("title", "物业列表");
        mapa.put("date", DateUtil.getCurrentDateString());

        ExcelUitlsTo.downByTmpl(mapa, "question-template.xls", "物业列表-" + DateUtil.date("YmdHis"), dtos, clazz, true, ids);
    }
}
