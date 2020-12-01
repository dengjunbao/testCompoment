package com.component.ExcelUtils.bo;

import com.component.ExcelUtils.model.SpmProperty;
import com.component.test.ExcelUtils.model.SpmProperty;

import java.math.BigDecimal;

/**
 * 物业信息管理模块
 */

public class SpmPropertyBo extends SpmProperty {

    /*************************************************************
     * 以下是对原有物业的部分属性状态显示结果的转换                    *
     *************************************************************/

    /**
     * 产权单位名称
     */
    private  String poname;
    public String getPoname() {
        return poname;
    }
    public void setPoname(String poname) {
        this.poname = poname;
    }

    /**
     * 物业详细地址
     */
    private  String proAddrDetail;
    public String getProAddrDetail() {
        return proAddrDetail;
    }
    public void setProAddrDetail(String proAddrDetail) {
        this.proAddrDetail = proAddrDetail;
    }

    /**
     * 土地功能类型
     */
    private  String prolandtypeName;
    public String getProlandtypeName() {
        return prolandtypeName;
    }
    public void setProlandtypeName(String prolandtypeName) {
        this.prolandtypeName = prolandtypeName;
    }

    /**
     * 租赁
     */
    private  String procurstatusName;
    public String getProcurstatusName() {
        return procurstatusName;
    }
    public void setProcurstatusName(String procurstatusName) {
        this.procurstatusName = procurstatusName;
    }

    /**
     * 租赁用途
     */
    private  String probusinesstypeName;
    public String getProbusinesstypeName() {
        return probusinesstypeName;
    }
    public void setProbusinesstypeName(String probusinesstypeName) {
        this.probusinesstypeName = probusinesstypeName;
    }

    /**
     * 抵押或查封 状态
     */
    private  String proMortgageOrSealName;
    public String getProMortgageOrSealName() {
        return proMortgageOrSealName;
    }
    public void setProMortgageOrSealName(String proMortgageOrSealName) {
        this.proMortgageOrSealName = proMortgageOrSealName;
    }

    /**
     * 有无消防证
     */
    private  String hasFireDepCerStatus;
    public String getHasFireDepCerStatus() {
        return hasFireDepCerStatus;
    }
    public void setHasFireDepCerStatus(String hasFireDepCerStatus) {
        this.hasFireDepCerStatus = hasFireDepCerStatus;
    }

    /**
     * 是否评估
     */
    private  String ifAssessName;
    public String getIfAssessName() {
        return ifAssessName;
    }
    public void setIfAssessName(String ifAssessName) {
        this.ifAssessName = ifAssessName;
    }
    /**
     * 是否集团用地
     */
    private  String isgrouplandName;
    public String getIsgrouplandName() {
        return isgrouplandName;
    }
    public void setIsgrouplandName(String isgrouplandName) {
        this.isgrouplandName = isgrouplandName;
    }

    /**
     * 管理员名称
     */
    private  String mgrName;
    public String getMgrName() {
        return mgrName;
    }
    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    /**
     * 有无电梯
     */
    private  String haveLiftStatus;
    public String getHaveLiftStatus() {
        return haveLiftStatus;
    }
    public void setHaveLiftStatus(String haveLiftStatus) {
        this.haveLiftStatus = haveLiftStatus;
    }

    /**
     * 有无车位
     */
    private  String haveCarportStatus;
    public String getHaveCarportStatus() {
        return haveCarportStatus;
    }
    public void setHaveCarportStatus(String haveCarportStatus) {
        this.haveCarportStatus = haveCarportStatus;
    }

    /**
     * 是否是物业评估文件关联关系创建人
     */
    private  String isAccessFileProertyCreator;
    public String getIsAccessFileProertyCreator() {
        return isAccessFileProertyCreator;
    }
    public void setIsAccessFileProertyCreator(String isAccessFileProertyCreator) {
        this.isAccessFileProertyCreator = isAccessFileProertyCreator;
    }

    /**
     * 更新时间
     */
    private  String updatedateString;
    public String getUpdatedateString() {
        return updatedateString;
    }
    public void setUpdatedateString(String updatedateString) {
        this.updatedateString = updatedateString;
    }


    /**
     * 更新人
     */
    private  String updatedbyAutor;
    public String getUpdatedbyAutor() {
        return updatedbyAutor;
    }
    public void setUpdatedbyAutor(String updatedbyAutor) {
        this.updatedbyAutor = updatedbyAutor;
    }

    /**
     * 与评估文件关系状态
     */
    private String accessCerState;
    public String getAccessCerState() {
        return accessCerState;
    }
    public void setAccessCerState(String accessCerState) {
        this.accessCerState = accessCerState;
    }
    /*************************************************************
     * 以下是物业对应的合同属性状态数值的整合转存，便于数据显示展示。     *
     *************************************************************/

    /****************************************************
     * 以下是合同表相关字段
     */

    /**
     * 承租人id
     */
    private  Integer renId;

    public Integer getRenId() {
        return renId;
    }

    public void setRenId(Integer renId) {
        this.renId = renId;
    }

    /**
     * 承租人
     */
    private  String renterName;
    public String getRenterName() {
        return renterName;
    }
    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    /**
     * 租赁押金
     */
    private BigDecimal totalDepositNum;
    public BigDecimal getTotalDepositNum() {
        return totalDepositNum;
    }
    public void setTotalDepositNum(BigDecimal totalDepositNum) {
        this.totalDepositNum = totalDepositNum;
    }

    /**
     * 租期
     */
    private Integer tenancyterm;
    public Integer getTenancyterm() {
        return tenancyterm;
    }
    public void setTenancyterm(Integer tenancyterm) {
        this.tenancyterm = tenancyterm;
    }

    /**
     * 合同状态
     */
    private String tenancyStatusName;
    public String getTenancyStatusName() {
        return tenancyStatusName;
    }
    public void setTenancyStatusName(String tenancyStatusName) {
        this.tenancyStatusName = tenancyStatusName;
    }

    /**
     * 合同签订日
     */
    private String signingdateString;
    public String getSigningdateString() {
        return signingdateString;
    }
    public void setSigningdateString(String signingdateString) {
        this.signingdateString = signingdateString;
    }

    /**
     * 起止日期
     */
    private  String begEndDate;
    public String getBegEndDate() {
        return begEndDate;
    }
    public void setBegEndDate(String begEndDate) {
        this.begEndDate = begEndDate;
    }

    /**
     * 起始日期
     */
    private  String beginDate;
    public String getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 终止日期
     */
    private  String endDate;
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 对比时间
     */
    private Integer contrastDate;
    public Integer getContrastDate() {
        return contrastDate;
    }
    public void setContrastDate(Integer contrastDate) {
        this.contrastDate = contrastDate;
    }

    /**
     * 起止租期
     */
    private String startAndEndDate;
    public String getStartAndEndDate() {
        return startAndEndDate;
    }
    public void setStartAndEndDate(String startAndEndDate) {
        this.startAndEndDate = startAndEndDate;
    }

    /**
     * 装修期
     */
    private BigDecimal decPeriodTime;
    public BigDecimal getDecPeriodTime() {
        return decPeriodTime;
    }
    public void setDecPeriodTime(BigDecimal decPeriodTime) {
        this.decPeriodTime = decPeriodTime;
    }

    /**
     * 合同附件
     */
    private String tenPhoatturl;
    public String getTenPhoatturl() {
        return tenPhoatturl;
    }
    public void setTenPhoatturl(String tenPhoatturl) {
        this.tenPhoatturl = tenPhoatturl;
    }


    /**
     * 租金缴纳日
     */
    private String payrentday;
    public String getPayrentday() {
        return payrentday;
    }
    public void setPayrentday(String payrentday) {
        this.payrentday = payrentday;
    }

    /**
     * 合同附件
     */
    private String phoatturl;
    @Override
    public String getPhoatturl() {
        return phoatturl;
    }
    @Override
    public void setPhoatturl(String phoatturl) {
        this.phoatturl = phoatturl;
    }

    /**
     * 签约代表
     */
    private String tenancySignatory;
    public String getTenancySignatory() {
        return tenancySignatory;
    }
    public void setTenancySignatory(String tenancySignatory) {
        this.tenancySignatory = tenancySignatory;
    }

    /**
     * 备注
     */
    private String tenRemarks;
    public String getTenRemarks() {
        return tenRemarks;
    }
    public void setTenRemarks(String tenRemarks) {
        this.tenRemarks = tenRemarks;
    }


    /****************************************************
     * 以下是合同关系表相关字段
     */

    /**出租合同Id
     * */
    private Integer tenId;
    public Integer getTenId() {
        return tenId;
    }
    public void setTenId(Integer tenId) {
        this.tenId = tenId;
    }

    /**出租合同编号
     */
    private String rtno;
    public String getRtno() {
        return rtno;
    }
    public void setRtno(String rtno) {
        this.rtno = rtno;
    }

    /**
     * 经营类型
     */
    private  Integer businesstype;
    public Integer getBusinesstype() {
        return businesstype;
    }
    public void setBusinesstype(Integer businesstype) {
        this.businesstype = businesstype;
    }

    /**
     * 经营类型名称
     */
    private  String businesstypeName;
    public String getBusinesstypeName() {
        return businesstypeName;
    }
    public void setBusinesstypeName(String businesstypeName) {
        this.businesstypeName = businesstypeName;
    }

    /**
     * 租用面积
     */
    private  BigDecimal tenarea;
    public BigDecimal getTenarea() {
        return tenarea;
    }
    public void setTenarea(BigDecimal tenarea) {
        this.tenarea = tenarea;
    }

    /**
     * 月租金
     */
    private  BigDecimal unitprice;
    public BigDecimal getUnitprice() {
        return unitprice;
    }
    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * 月租金单价/(元/㎡)
     */
    private  BigDecimal unitpricepersm;
    public BigDecimal getUnitpricepersm() {
        return unitpricepersm;
    }
    public void setUnitpricepersm(BigDecimal unitpricepersm) {
        this.unitpricepersm = unitpricepersm;
    }

    /**
     * 租金总额
     */
    private  BigDecimal totalprice;
    public BigDecimal getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    /**
     * 管理费
     */
    private  BigDecimal mgrfee;
    public BigDecimal getMgrfee() {
        return mgrfee;
    }
    public void setMgrfee(BigDecimal mgrfee) {
        this.mgrfee = mgrfee;
    }

    /**
     * 月管理费单价/(元/㎡)
     */
    private  BigDecimal mgrfeepersm;
    public BigDecimal getMgrfeepersm() {
        return mgrfeepersm;
    }
    public void setMgrfeepersm(BigDecimal mgrfeepersm) {
        this.mgrfeepersm = mgrfeepersm;
    }

    /**
     * 物业管理方式
     * */
    private String manageTypeName;

    public String getManageTypeName() {
        return manageTypeName;
    }

    public void setManageTypeName(String manageTypeName) {
        this.manageTypeName = manageTypeName;
    }

    /**
     * 房屋所有证证件编号
     * */
    private String ownCerNo;
    public String getOwnCerNo() {
        return ownCerNo;
    }
    public void setOwnCerNo(String ownCerNo) {
        this.ownCerNo = ownCerNo;
    }


    /**
     * 证件类型
     */
    private String cerName;

    public String getCerName() {
        return cerName;
    }

    public void setCerName(String cerName) {
        this.cerName = cerName;
    }

    /*
    *
    * 租用申请id
    * */
    private Integer rrId;

    public Integer getRrId() {
        return rrId;
    }

    public void setRrId(Integer rrId) {
        this.rrId = rrId;
    }

    /**
     * 标记该租户是否被申请 0：未申请  1：已申请  2:已处理
     */


    private Integer isApply;
    public Integer getIsApply() {
        return isApply;
    }

    public void setIsApply(Integer isApply) {
        this.isApply = isApply;
    }


    /*配套信息图片ID*/
    private Integer outfitProAttUrlId;

    public Integer getOutfitProAttUrlId() {
        return outfitProAttUrlId;
    }

    public void setOutfitProAttUrlId(Integer outfitProAttUrlId) {
        this.outfitProAttUrlId = outfitProAttUrlId;
    }


    //宏源项目，用来存放多个物业现状的字符串
    private String procur;

    public String getProcur() {
        return procur;
    }

    public void setProcur(String procur) {
        this.procur = procur;
    }

    //宏源项目，用来存放多个物业现状type的字符串用，隔开

    private String curStatusType;

    public String getCurStatusType() {
        return curStatusType;
    }

    public void setCurStatusType(String curStatusType) {
        this.curStatusType = curStatusType;
    }
}
















