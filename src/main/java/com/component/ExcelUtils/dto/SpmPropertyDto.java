package com.component.ExcelUtils.dto;


import com.component.test.ExcelUtils.annotation.ExcelResources;

import java.math.BigDecimal;

public class SpmPropertyDto {


    /**
     * 物业信息ID
     */
    private Integer id;

    /**
     * 物业编号
     */
    private String prono;

    /**
     * 房屋名称及位置
     */
    private String proname;

    /**
     * 管理方式
     */
    private String  manageTypeName;

    /**
     * 物业证件编号
     */
    private String proidentityno;



    /**
     * 房产面积
     */
    private BigDecimal proarea;

    /**
     *
     * 行政区
     */
    private  String cantonName;

    /**
     *街道/镇
     */
    private String areaName;

    /**
     *证书名称
     */
    private String cerName;


/*    @ExcelResources(title = "序号", order = 1, width = 8)
    public Integer getId() {
        return id;
    }*/

    public void setProno(String prono) {
        this.prono = prono;
    }
    @ExcelResources(title = "物业编号", order = 1, width = 15)
    public String getProno() {
        return prono;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ExcelResources(title = "物业名称", order = 2, width = 45)
    public String getProname() {
        return proname;
    }

    @ExcelResources(title = "管理方式", order = 3, width = 12)
    public String  getManageTypeName() {
        return manageTypeName;
    }

    public void setManageTypeName(String manageTypeName) {
        this.manageTypeName = manageTypeName;
    }



    /**
     * 产权单位名称
     */
    private  String poname;
    @ExcelResources(title = "产权单位", order = 4, width = 30)
    public String getPoname() {
        return poname;
    }
    public void setPoname(String poname) {
        this.poname = poname;
    }


    public void setProname(String proname) {
        this.proname = proname;
    }
    @ExcelResources(title = "证件编号", order = 5, width = 15)
    public String getProidentityno() {
        return proidentityno;
    }

    public void setProidentityno(String proidentityno) {
        this.proidentityno = proidentityno;
    }

    @ExcelResources(title = "物业面积(m²)", order = 6, width = 15)
    public BigDecimal getProarea() {
        return proarea;
    }

    public void setProarea(BigDecimal proarea) {
        this.proarea = proarea;
    }

    /**
     * 房产现状
     */
    private  String procurstatusName;
    @ExcelResources(title = "租约状态", order = 7, width = 12)
    public String getProcurstatusName() {
        return procurstatusName;
    }
    public void setProcurstatusName(String procurstatusName) {
        this.procurstatusName = procurstatusName;
    }



    /**
     * 经营类型名称
     */
    private  String businesstypeName;
    @ExcelResources(title = "租赁用途", order = 8, width = 12)
    public String getBusinesstypeName() {
        return businesstypeName;
    }
    public void setBusinesstypeName(String businesstypeName) {
        this.businesstypeName = businesstypeName;
    }

    /**
     * 月租金单价
     */
    private  BigDecimal unitpricepersm;
    @ExcelResources(title = "月租金单价(元/m²)", order = 9, width = 20)
    public BigDecimal getUnitpricepersm() {
        return unitpricepersm;
    }
    public void setUnitpricepersm(BigDecimal unitpricepersm) {
        this.unitpricepersm = unitpricepersm;
    }

    /**
     * 月租金总价
     */
    private  BigDecimal unitprice;
    @ExcelResources(title = "月租金总价(元)", order = 10, width = 18)
    public BigDecimal getUnitprice() {
        return unitprice;
    }
    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    @ExcelResources(title = "行政区", order = 11, width = 12)
    public String getCantonName() {
        return cantonName;
    }

    public void setCantonName(String cantonName) {
        this.cantonName = cantonName;
    }
    @ExcelResources(title = "街道/镇", order = 12, width = 12)
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    @ExcelResources(title = "证件名称", order = 13, width = 12)
    public String getCerName() {
        return cerName;
    }

    public void setCerName(String cerName) {
        this.cerName = cerName;
    }
}
