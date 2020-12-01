package com.component.ExcelUtils.model;

import com.component.test.ExcelUtils.base.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "spm_property")
public class SpmProperty extends BaseModel {
    /**
     * 物业信息ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产权单位ID
     */
    @Column(name = "oId")
    private Integer oid;

    /**
     * 资产类型，0：备用，1：物业，2：土地。用以区分基础属性是物业、或土地资源；也可能同时多种性质共存。
     */
    @Column(name = "proBaseType")
    private String probasetype;

    /**
     * 产权单位类型，1：市政，2：其它，3：物管公司
     */
    @Column(name = "ownerType")
    private Byte ownertype;

    /**
     * 物业编号，物业编号规则：年份-【类别-产权单位编码】- 4位数字。
     */
    @Column(name = "proNo")
    private String prono;

    /**
     * 房屋名称及位置
     */
    @Column(name = "proName")
    private String proname;

    /**
     * 物业曾用名
     */
    @Column(name = "proPrevName")
    private String proprevname;

    /**
     * 物业地图定位信息
     */
    @Column(name = "proAddress")
    private String proaddress;

    /**
     * (CJ)物业管理方式，1：自有，2：集团托管，3：财局托管。[其它公司项目的管理类型定义在对应的配置文件中]
     */
    @Column(name = "manageType")
    private Byte managetype;

    /**
     * 土地功能(或实际功能)
     */
    @Column(name = "proLandType")
    private Integer prolandtype;

    /**
     * 物业租赁用途(对等合同经营类型)
     */
    @Column(name = "proBusinessType")
    private Byte probusinesstype;

    /**
     * 是否集团用地
     */
    @Column(name = "isGroupLand")
    private Byte isgroupland;

    /**
     * [物业类型]房产面积
     */
    @Column(name = "proArea")
    private BigDecimal proarea;

    /**
     * [物业类型]物业面积的描述，用于早期用“间”、“房”、“楼顶”之类的非具体面积的描述。
     */
    @Column(name = "proAreaDesc")
    private String proareadesc;

    /**
     * [物业类型]可租赁面积
     */
    @Column(name = "leaArea")
    private BigDecimal leaarea;

    /**
     * [物业类型]已租赁面积
     */
    @Column(name = "leasedArea")
    private BigDecimal leasedarea;

    /**
     * [物业类型]不可出租部分的原因备注
     */
    @Column(name = "noRentRemarks")
    private String norentremarks;

    /**
     * [土地类型]土地面积
     */
    @Column(name = "landArea")
    private BigDecimal landarea;

    /**
     * [土地类型]土地可租赁面积
     */
    @Column(name = "landLeaArea")
    private BigDecimal landleaarea;

    /**
     * [土地类型]土地已租赁面积
     */
    @Column(name = "landLeasedArea")
    private BigDecimal landleasedarea;

    /**
     * [土地类型]不可出租部分的原因备注
     */
    @Column(name = "landNoRentRemarks")
    private String landnorentremarks;

    /**
     * [唯一状态]房产(|资产)现状|(租约情况)类型，0：备用占用，1：整体出租，2：完全空置，3：部分空置(部分出租)，4：危房，5：员工占用
     */
    @Column(name = "proCurStatus")
    private Integer procurstatus;

    /**
     * 楼层
     */
    private Byte floor;

    /**
     * 有无消防证（0：无，1：有）
     */
    @Column(name = "hasFireDepCer")
    private Byte hasfiredepcer;

    /**
     * 消防证文件附件ID
     */
    @Column(name = "fireDepCerAttUrl")
    private String firedepceratturl;

    /**
     * 0：无，1：抵押，2：查封
     */
    @Column(name = "proMortgageOrSeal")
    private Byte promortgageorseal;

    /**
     * 抵押或查封文件附件
     */
    @Column(name = "proMorOrSealAttUrl")
    private String promororsealatturl;

    /**
     * 物业证件(房产证)编号
     */
    @Column(name = "proIdentityNO")
    private String proidentityno;

    /**
     * 物业证件(房产证)图片文件
     */
    @Column(name = "proIdentityAttUrl")
    private String proidentityatturl;

    /**
     * 是否评估（0否，1是）
     */
    @Column(name = "IfAssess")
    private Byte ifassess;

    /**
     * 物业评估文件附件
     */
    @Column(name = "assessAttUrl")
    private String assessatturl;

    /**
     * 物业信息相关附件
     */
    @Column(name = "phoAttUrl")
    private String phoatturl;

    /**
     * 有无电梯
     */
    @Column(name = "haveLift")
    private Byte havelift;

    /**
     * 有无车位
     */
    @Column(name = "haveCarport")
    private Byte havecarport;

    /**
     * 物业管理员
     */
    @Column(name = "mgrId")
    private Integer mgrid;

    /**
     * 物业(信息)状态（0：待启用，1：正常，3：未提交(保存)，4：待审核，5：审核未通过）
     */
    private Byte state;

    /**
     * 用于批量导入，0：占位，1：人工编辑过，2：静态导入
     */
    @Column(name = "isCorrect")
    private Byte iscorrect;

    @Column(name = "isLogicDel")
    private Boolean islogicdel;

    @Column(name = "groupId")
    private Integer groupid;

    /**
     * 创建人
     */
    @Column(name = "createdBy")
    private Integer createdby;

    /**
     * 创建时间
     */
    @Column(name = "createdAt")
    private Integer createdat;

    /**
     * 更新人
     */
    @Column(name = "updatedBy")
    private Integer updatedby;

    /**
     * 更新时间
     */
    @Column(name = "updatedAt")
    private Integer updatedat;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 获取物业信息ID
     *
     * @return id - 物业信息ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置物业信息ID
     *
     * @param id 物业信息ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产权单位ID
     *
     * @return oId - 产权单位ID
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * 设置产权单位ID
     *
     * @param oid 产权单位ID
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * 获取资产类型，0：备用，1：物业，2：土地。用以区分基础属性是物业、或土地资源；也可能同时多种性质共存。
     *
     * @return proBaseType - 资产类型，0：备用，1：物业，2：土地。用以区分基础属性是物业、或土地资源；也可能同时多种性质共存。
     */
    public String getProbasetype() {
        return probasetype;
    }

    /**
     * 设置资产类型，0：备用，1：物业，2：土地。用以区分基础属性是物业、或土地资源；也可能同时多种性质共存。
     *
     * @param probasetype 资产类型，0：备用，1：物业，2：土地。用以区分基础属性是物业、或土地资源；也可能同时多种性质共存。
     */
    public void setProbasetype(String probasetype) {
        this.probasetype = probasetype;
    }

    /**
     * 获取产权单位类型，1：市政，2：其它，3：物管公司
     *
     * @return ownerType - 产权单位类型，1：市政，2：其它，3：物管公司
     */
    public Byte getOwnertype() {
        return ownertype;
    }

    /**
     * 设置产权单位类型，1：市政，2：其它，3：物管公司
     *
     * @param ownertype 产权单位类型，1：市政，2：其它，3：物管公司
     */
    public void setOwnertype(Byte ownertype) {
        this.ownertype = ownertype;
    }

    /**
     * 获取物业编号，物业编号规则：年份-【类别-产权单位编码】- 4位数字。
     *
     * @return proNo - 物业编号，物业编号规则：年份-【类别-产权单位编码】- 4位数字。
     */
    public String getProno() {
        return prono;
    }

    /**
     * 设置物业编号，物业编号规则：年份-【类别-产权单位编码】- 4位数字。
     *
     * @param prono 物业编号，物业编号规则：年份-【类别-产权单位编码】- 4位数字。
     */
    public void setProno(String prono) {
        this.prono = prono;
    }

    /**
     * 获取房屋名称及位置
     *
     * @return proName - 房屋名称及位置
     */
    public String getProname() {
        return proname;
    }

    /**
     * 设置房屋名称及位置
     *
     * @param proname 房屋名称及位置
     */
    public void setProname(String proname) {
        this.proname = proname;
    }

    /**
     * 获取物业曾用名
     *
     * @return proPrevName - 物业曾用名
     */
    public String getProprevname() {
        return proprevname;
    }

    /**
     * 设置物业曾用名
     *
     * @param proprevname 物业曾用名
     */
    public void setProprevname(String proprevname) {
        this.proprevname = proprevname;
    }

    /**
     * 获取物业地图定位信息
     *
     * @return proAddress - 物业地图定位信息
     */
    public String getProaddress() {
        return proaddress;
    }

    /**
     * 设置物业地图定位信息
     *
     * @param proaddress 物业地图定位信息
     */
    public void setProaddress(String proaddress) {
        this.proaddress = proaddress;
    }

    /**
     * 获取(CJ)物业管理方式，1：自有，2：集团托管，3：财局托管。[其它公司项目的管理类型定义在对应的配置文件中]
     *
     * @return manageType - (CJ)物业管理方式，1：自有，2：集团托管，3：财局托管。[其它公司项目的管理类型定义在对应的配置文件中]
     */
    public Byte getManagetype() {
        return managetype;
    }

    /**
     * 设置(CJ)物业管理方式，1：自有，2：集团托管，3：财局托管。[其它公司项目的管理类型定义在对应的配置文件中]
     *
     * @param managetype (CJ)物业管理方式，1：自有，2：集团托管，3：财局托管。[其它公司项目的管理类型定义在对应的配置文件中]
     */
    public void setManagetype(Byte managetype) {
        this.managetype = managetype;
    }

    /**
     * 获取土地功能(或实际功能)
     *
     * @return proLandType - 土地功能(或实际功能)
     */
    public Integer getProlandtype() {
        return prolandtype;
    }

    /**
     * 设置土地功能(或实际功能)
     *
     * @param prolandtype 土地功能(或实际功能)
     */
    public void setProlandtype(Integer prolandtype) {
        this.prolandtype = prolandtype;
    }

    /**
     * 获取物业租赁用途(对等合同经营类型)
     *
     * @return proBusinessType - 物业租赁用途(对等合同经营类型)
     */
    public Byte getProbusinesstype() {
        return probusinesstype;
    }

    /**
     * 设置物业租赁用途(对等合同经营类型)
     *
     * @param probusinesstype 物业租赁用途(对等合同经营类型)
     */
    public void setProbusinesstype(Byte probusinesstype) {
        this.probusinesstype = probusinesstype;
    }

    /**
     * 获取是否集团用地
     *
     * @return isGroupLand - 是否集团用地
     */
    public Byte getIsgroupland() {
        return isgroupland;
    }

    /**
     * 设置是否集团用地
     *
     * @param isgroupland 是否集团用地
     */
    public void setIsgroupland(Byte isgroupland) {
        this.isgroupland = isgroupland;
    }

    /**
     * 获取[物业类型]房产面积
     *
     * @return proArea - [物业类型]房产面积
     */
    public BigDecimal getProarea() {
        return proarea;
    }

    /**
     * 设置[物业类型]房产面积
     *
     * @param proarea [物业类型]房产面积
     */
    public void setProarea(BigDecimal proarea) {
        this.proarea = proarea;
    }

    /**
     * 获取[物业类型]物业面积的描述，用于早期用“间”、“房”、“楼顶”之类的非具体面积的描述。
     *
     * @return proAreaDesc - [物业类型]物业面积的描述，用于早期用“间”、“房”、“楼顶”之类的非具体面积的描述。
     */
    public String getProareadesc() {
        return proareadesc;
    }

    /**
     * 设置[物业类型]物业面积的描述，用于早期用“间”、“房”、“楼顶”之类的非具体面积的描述。
     *
     * @param proareadesc [物业类型]物业面积的描述，用于早期用“间”、“房”、“楼顶”之类的非具体面积的描述。
     */
    public void setProareadesc(String proareadesc) {
        this.proareadesc = proareadesc;
    }

    /**
     * 获取[物业类型]可租赁面积
     *
     * @return leaArea - [物业类型]可租赁面积
     */
    public BigDecimal getLeaarea() {
        return leaarea;
    }

    /**
     * 设置[物业类型]可租赁面积
     *
     * @param leaarea [物业类型]可租赁面积
     */
    public void setLeaarea(BigDecimal leaarea) {
        this.leaarea = leaarea;
    }

    /**
     * 获取[物业类型]已租赁面积
     *
     * @return leasedArea - [物业类型]已租赁面积
     */
    public BigDecimal getLeasedarea() {
        return leasedarea;
    }

    /**
     * 设置[物业类型]已租赁面积
     *
     * @param leasedarea [物业类型]已租赁面积
     */
    public void setLeasedarea(BigDecimal leasedarea) {
        this.leasedarea = leasedarea;
    }

    /**
     * 获取[物业类型]不可出租部分的原因备注
     *
     * @return noRentRemarks - [物业类型]不可出租部分的原因备注
     */
    public String getNorentremarks() {
        return norentremarks;
    }

    /**
     * 设置[物业类型]不可出租部分的原因备注
     *
     * @param norentremarks [物业类型]不可出租部分的原因备注
     */
    public void setNorentremarks(String norentremarks) {
        this.norentremarks = norentremarks;
    }

    /**
     * 获取[土地类型]土地面积
     *
     * @return landArea - [土地类型]土地面积
     */
    public BigDecimal getLandarea() {
        return landarea;
    }

    /**
     * 设置[土地类型]土地面积
     *
     * @param landarea [土地类型]土地面积
     */
    public void setLandarea(BigDecimal landarea) {
        this.landarea = landarea;
    }

    /**
     * 获取[土地类型]土地可租赁面积
     *
     * @return landLeaArea - [土地类型]土地可租赁面积
     */
    public BigDecimal getLandleaarea() {
        return landleaarea;
    }

    /**
     * 设置[土地类型]土地可租赁面积
     *
     * @param landleaarea [土地类型]土地可租赁面积
     */
    public void setLandleaarea(BigDecimal landleaarea) {
        this.landleaarea = landleaarea;
    }

    /**
     * 获取[土地类型]土地已租赁面积
     *
     * @return landLeasedArea - [土地类型]土地已租赁面积
     */
    public BigDecimal getLandleasedarea() {
        return landleasedarea;
    }

    /**
     * 设置[土地类型]土地已租赁面积
     *
     * @param landleasedarea [土地类型]土地已租赁面积
     */
    public void setLandleasedarea(BigDecimal landleasedarea) {
        this.landleasedarea = landleasedarea;
    }

    /**
     * 获取[土地类型]不可出租部分的原因备注
     *
     * @return landNoRentRemarks - [土地类型]不可出租部分的原因备注
     */
    public String getLandnorentremarks() {
        return landnorentremarks;
    }

    /**
     * 设置[土地类型]不可出租部分的原因备注
     *
     * @param landnorentremarks [土地类型]不可出租部分的原因备注
     */
    public void setLandnorentremarks(String landnorentremarks) {
        this.landnorentremarks = landnorentremarks;
    }

    /**
     * 获取[唯一状态]房产(|资产)现状|(租约情况)类型，0：备用占用，1：整体出租，2：完全空置，3：部分空置(部分出租)，4：危房，5：员工占用
     *
     * @return proCurStatus - [唯一状态]房产(|资产)现状|(租约情况)类型，0：备用占用，1：整体出租，2：完全空置，3：部分空置(部分出租)，4：危房，5：员工占用
     */
    public Integer getProcurstatus() {
        return procurstatus;
    }

    /**
     * 设置[唯一状态]房产(|资产)现状|(租约情况)类型，0：备用占用，1：整体出租，2：完全空置，3：部分空置(部分出租)，4：危房，5：员工占用
     *
     * @param procurstatus [唯一状态]房产(|资产)现状|(租约情况)类型，0：备用占用，1：整体出租，2：完全空置，3：部分空置(部分出租)，4：危房，5：员工占用
     */
    public void setProcurstatus(Integer procurstatus) {
        this.procurstatus = procurstatus;
    }

    /**
     * 获取楼层
     *
     * @return floor - 楼层
     */
    public Byte getFloor() {
        return floor;
    }

    /**
     * 设置楼层
     *
     * @param floor 楼层
     */
    public void setFloor(Byte floor) {
        this.floor = floor;
    }

    /**
     * 获取有无消防证（0：无，1：有）
     *
     * @return hasFireDepCer - 有无消防证（0：无，1：有）
     */
    public Byte getHasfiredepcer() {
        return hasfiredepcer;
    }

    /**
     * 设置有无消防证（0：无，1：有）
     *
     * @param hasfiredepcer 有无消防证（0：无，1：有）
     */
    public void setHasfiredepcer(Byte hasfiredepcer) {
        this.hasfiredepcer = hasfiredepcer;
    }

    /**
     * 获取消防证文件附件ID
     *
     * @return fireDepCerAttUrl - 消防证文件附件ID
     */
    public String getFiredepceratturl() {
        return firedepceratturl;
    }

    /**
     * 设置消防证文件附件ID
     *
     * @param firedepceratturl 消防证文件附件ID
     */
    public void setFiredepceratturl(String firedepceratturl) {
        this.firedepceratturl = firedepceratturl;
    }

    /**
     * 获取0：无，1：抵押，2：查封
     *
     * @return proMortgageOrSeal - 0：无，1：抵押，2：查封
     */
    public Byte getPromortgageorseal() {
        return promortgageorseal;
    }

    /**
     * 设置0：无，1：抵押，2：查封
     *
     * @param promortgageorseal 0：无，1：抵押，2：查封
     */
    public void setPromortgageorseal(Byte promortgageorseal) {
        this.promortgageorseal = promortgageorseal;
    }

    /**
     * 获取抵押或查封文件附件
     *
     * @return proMorOrSealAttUrl - 抵押或查封文件附件
     */
    public String getPromororsealatturl() {
        return promororsealatturl;
    }

    /**
     * 设置抵押或查封文件附件
     *
     * @param promororsealatturl 抵押或查封文件附件
     */
    public void setPromororsealatturl(String promororsealatturl) {
        this.promororsealatturl = promororsealatturl;
    }

    /**
     * 获取物业证件(房产证)编号
     *
     * @return proIdentityNO - 物业证件(房产证)编号
     */
    public String getProidentityno() {
        return proidentityno;
    }

    /**
     * 设置物业证件(房产证)编号
     *
     * @param proidentityno 物业证件(房产证)编号
     */
    public void setProidentityno(String proidentityno) {
        this.proidentityno = proidentityno;
    }

    /**
     * 获取物业证件(房产证)图片文件
     *
     * @return proIdentityAttUrl - 物业证件(房产证)图片文件
     */
    public String getProidentityatturl() {
        return proidentityatturl;
    }

    /**
     * 设置物业证件(房产证)图片文件
     *
     * @param proidentityatturl 物业证件(房产证)图片文件
     */
    public void setProidentityatturl(String proidentityatturl) {
        this.proidentityatturl = proidentityatturl;
    }

    /**
     * 获取是否评估（0否，1是）
     *
     * @return IfAssess - 是否评估（0否，1是）
     */
    public Byte getIfassess() {
        return ifassess;
    }

    /**
     * 设置是否评估（0否，1是）
     *
     * @param ifassess 是否评估（0否，1是）
     */
    public void setIfassess(Byte ifassess) {
        this.ifassess = ifassess;
    }

    /**
     * 获取物业评估文件附件
     *
     * @return assessAttUrl - 物业评估文件附件
     */
    public String getAssessatturl() {
        return assessatturl;
    }

    /**
     * 设置物业评估文件附件
     *
     * @param assessatturl 物业评估文件附件
     */
    public void setAssessatturl(String assessatturl) {
        this.assessatturl = assessatturl;
    }

    /**
     * 获取物业信息相关附件
     *
     * @return phoAttUrl - 物业信息相关附件
     */
    public String getPhoatturl() {
        return phoatturl;
    }

    /**
     * 设置物业信息相关附件
     *
     * @param phoatturl 物业信息相关附件
     */
    public void setPhoatturl(String phoatturl) {
        this.phoatturl = phoatturl;
    }

    /**
     * 获取有无电梯
     *
     * @return haveLift - 有无电梯
     */
    public Byte getHavelift() {
        return havelift;
    }

    /**
     * 设置有无电梯
     *
     * @param havelift 有无电梯
     */
    public void setHavelift(Byte havelift) {
        this.havelift = havelift;
    }

    /**
     * 获取有无车位
     *
     * @return haveCarport - 有无车位
     */
    public Byte getHavecarport() {
        return havecarport;
    }

    /**
     * 设置有无车位
     *
     * @param havecarport 有无车位
     */
    public void setHavecarport(Byte havecarport) {
        this.havecarport = havecarport;
    }

    /**
     * 获取物业管理员
     *
     * @return mgrId - 物业管理员
     */
    public Integer getMgrid() {
        return mgrid;
    }

    /**
     * 设置物业管理员
     *
     * @param mgrid 物业管理员
     */
    public void setMgrid(Integer mgrid) {
        this.mgrid = mgrid;
    }

    /**
     * 获取物业(信息)状态（0：待启用，1：正常，3：未提交(保存)，4：待审核，5：审核未通过）
     *
     * @return state - 物业(信息)状态（0：待启用，1：正常，3：未提交(保存)，4：待审核，5：审核未通过）
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置物业(信息)状态（0：待启用，1：正常，3：未提交(保存)，4：待审核，5：审核未通过）
     *
     * @param state 物业(信息)状态（0：待启用，1：正常，3：未提交(保存)，4：待审核，5：审核未通过）
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取用于批量导入，0：占位，1：人工编辑过，2：静态导入
     *
     * @return isCorrect - 用于批量导入，0：占位，1：人工编辑过，2：静态导入
     */
    public Byte getIscorrect() {
        return iscorrect;
    }

    /**
     * 设置用于批量导入，0：占位，1：人工编辑过，2：静态导入
     *
     * @param iscorrect 用于批量导入，0：占位，1：人工编辑过，2：静态导入
     */
    public void setIscorrect(Byte iscorrect) {
        this.iscorrect = iscorrect;
    }

    /**
     * @return isLogicDel
     */
    public Boolean getIslogicdel() {
        return islogicdel;
    }

    /**
     * @param islogicdel
     */
    public void setIslogicdel(Boolean islogicdel) {
        this.islogicdel = islogicdel;
    }

    /**
     * @return groupId
     */
    public Integer getGroupid() {
        return groupid;
    }

    /**
     * @param groupid
     */
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    /**
     * 获取创建人
     *
     * @return createdBy - 创建人
     */
    public Integer getCreatedby() {
        return createdby;
    }

    /**
     * 设置创建人
     *
     * @param createdby 创建人
     */
    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    /**
     * 获取创建时间
     *
     * @return createdAt - 创建时间
     */
    public Integer getCreatedat() {
        return createdat;
    }

    /**
     * 设置创建时间
     *
     * @param createdat 创建时间
     */
    public void setCreatedat(Integer createdat) {
        this.createdat = createdat;
    }

    /**
     * 获取更新人
     *
     * @return updatedBy - 更新人
     */
    public Integer getUpdatedby() {
        return updatedby;
    }

    /**
     * 设置更新人
     *
     * @param updatedby 更新人
     */
    public void setUpdatedby(Integer updatedby) {
        this.updatedby = updatedby;
    }

    /**
     * 获取更新时间
     *
     * @return updatedAt - 更新时间
     */
    public Integer getUpdatedat() {
        return updatedat;
    }

    /**
     * 设置更新时间
     *
     * @param updatedat 更新时间
     */
    public void setUpdatedat(Integer updatedat) {
        this.updatedat = updatedat;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}