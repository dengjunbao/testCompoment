package com.component.test.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: bao
 * @Date: 2020/5/8 0008 15:19
 */
public class AssetsBo {

    /**
     * 产权单位
     */
    @Column(name = "oId")
    private String oName;

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
     * 物业管理方式，1：自有，2：集团托管，3：财局托管
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
     * 房产面积
     */
    @Column(name = "proArea")
    private BigDecimal proarea;

    /**
     * 可租赁面积
     */
    @Column(name = "leaArea")
    private BigDecimal leaarea;

    /**
     * 已租赁面积
     */
    @Column(name = "leasedArea")
    private BigDecimal leasedarea;

    /**
     * 不可出租部分的原因备注
     */
    @Column(name = "noRentRemarks")
    private String norentremarks;

    /**
     * 房产现状(租约情况)类型，1：整体出租，2：完全空置，3：部分空置(部分出租)，4：危房，5：员工占用
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
     * 备注
     */
    private String remarks;
}
