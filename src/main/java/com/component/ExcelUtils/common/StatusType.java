package com.component.ExcelUtils.common;

/**
 * @author bao
 * @description 状态
 * @date 2019/5/10
 */
public class StatusType {

    //合同表的状态
    public static final Integer STATUS_UNENABLE       = 0;  //待启用
    public static final Integer STATUS_NORMAL         = 1;  //正常
    public static final Integer STATUS_SCHEEDULE      = 2;  //临期
    public static final Integer STATUS_EXPIRE         = 3;  //到期
    public static final Integer STATUS_INVALIDATION   = 4;  //提前终止
    public static final Integer STATUS_NOTSUBMITTED   = 5;  //未提交
    public static final Integer STATUS_AWAITAUDITED   = 6;  //待审核
    public static final Integer STATUS_AUDITFAILED    = 7;  //审核未通过
    public static final Integer STATUS_DELAY          = 8;  //延期


    //出租合同物业关系表的状态
    public static final Integer TP_STATUS_UNENABLE    = 0;  //待启用
    public static final Integer TP_STATUS_VALID       = 1;  //有效
    public static final Integer TP_STATUS_TERMINATION = 2;  //关系终止
    //租赁经营合同物业关系表的状态
    public static final Integer EP_STATUS_UNENABLE    = 0;  //无效
    public static final Integer EP_STATUS_VALID       = 1;  //有效

    //审批表
    //审批状态
    public static final Integer APPROVAL_STATUS_NOPASS              = 0; //未通过
    public static final Integer APPROVAL_STATUS_PASS                = 1; //通过
    public static final Integer APPROVAL_STATUS_APPROVALING         = 2; //审批中
    //续签合同状态
    public static final Integer RENEWCONTRACT_STATUS_ADDITIONAL     = 0; //待补录
    public static final Integer RENEWCONTRACT_STATUS_ACCOMPLISH     = 1; //已完成
    public static final Integer RENEWCONTRACT_STATUS_LIMITOPERATION = 2; //限制操作
    //审批事件时效性
    public static final Integer TIMELINESS_STATUS_LOSEEFFICACY      = 0; //失效
    public static final Integer TIMELINESS_STATUS_VALID             = 1; //有效
    public static final Integer  TIMELINESS_STATUS_LIMITOPERATION   = 2; //限制操作

    //物业表





    //物业产权单位类型
    public static final Integer PRO_OWNERTYPE_MUNICIPAL       =1;  //市政
    public static final Integer PRO_OWNERTYPE_OTHER           =2;  //其他
    public static final Integer PRO_OWNERTYPE_PROMANAGEMENT   =3;  //物管公司
    //账单模块
    //录账状态
    public static final Integer BILL_STATUS_ACCOUNT_NO  = 0; //未录账
    public static final Integer BILL_STATUS_ACCOUNT_YES = 1; //已结清
    public static final Integer BILL_STATUS_ACCOUNT_OWE = 2; //已录账，未结清
    public static final Integer BILL_STATUS_UNIONPAY_FAIL = 3; //银联托收失败
    //账单逾期状态
    public static final Integer BILL_ISOVERDUE_NOT      = 0; //未逾期
    public static final Integer BILL_ISOVERDUE_YES      = 1; //已逾期
    //账单类型
    public static final Integer BILL_TYPE_TEN               = 1; //租金账单
    public static final Integer BILL_TYPE_MGRFEE            = 2; //管理费账单
    public static final Integer BILL_TYPE_WATERELECTRICITY  = 3; //水电费账单
    public static final Integer BILL_TYPE_SERVICECHARGE     = 4; //手续费账单
    public static final Integer BILL_TYPE_OTHER             = 5; //其他账单

    //统计的报表展示方式
    //public static final String STATISTIC_DAY="DAY";

    //待办事项状态achieve
    public static final Integer PER_AFTER_NOSTART  = 0; //未开始
    public static final Integer PER_AFTER_STARTING = 1; //跟踪中
    public static final Integer PER_AFTER_ACHIEVE  = 2; //已完成

    //个人中心提醒周期类型
    public static final Integer PER_REMINDTYPE_DATE = 0; //固定日期
    public static final Integer PER_REMINDTYPE_DAY  = 1; //固定天数

    //个人中心待办事项已读状态
    public static final Integer PER_REMINDTYPE_READNOT  = 0; //未读
    public static final Integer PER_REMINDTYPE_READYES  = 1; //已读

    //个人中心待办事项消息推送终端
    public static final Integer PER_PUSHCHANNEL_ALL     = 0; //所有通道
    public static final Integer PER_PUSHCHANNEL_WEB     = 1; //web端
    public static final Integer PER_PUSHCHANNEL_APP     = 2; //app推送
    public static final Integer PER_PUSHCHANNEL_APPWSK  = 3; //appWsk

    //租赁合同甲方类型，0：物业管理公司，1：产权单位
    public static final Integer TEN_FIRST_PARTY_DEFAULT = 0; //物业管理公司
    public static final Integer TEN_FIRST_PARTY_OWNER   = 1; //产权单位
    public static final Integer TEN_FIRST_PARTY_OTHER   = 2; //第三方

    //事件提醒类型
    public static final Integer ALTER_TYPE_TODO     = 1; //待办事项
    public static final Integer ALTER_TEN_TYPE_CONTRACT = 2; //出租合同临期
    public static final Integer ALTER_TEN_TYPE_BILL     = 3; //收款账单逾期提醒
    public static final Integer ALTER_TYPE_TASK     = 4; //任务
    public static final Integer ALTER_TYPE_REPAIR   = 5; //报修
    public static final Integer ALTER_TYPE_Rate     = 6; //租金变更
    public static final Integer ALTER_TEN_REFUND_TYPE         = 7; //收的押金返还
    public static final Integer ALTER_ENT_TYPE_CONTRACT  =8; //委托合同临期
    public static final Integer ALTER_ENT_TYPE_BILL  =9; //付款账单逾期提醒
    public static final Integer ALTER_ENT_REFUND_TYPE  =10; //给的押金返还
    //阅读状态
    public static final Integer READ_STATUS_NOT     = 0; //未读
    public static final Integer READ_STATUS_YES     = 1; //已读
    //提醒消息状态
    public static final Integer ALERT_MSG_UNENABLE  = 0; //过期失效
    public static final Integer ALERT_MSG_VALID     = 1; //有效
    //待办事项启用状态
    public static final Integer TODO_STATE_NOT      = 0; //禁用
    public static final Integer TODO_STATE_YES      = 1; //启用
    //待办事项记录表完成状态
    public static final Integer TODO_RECORD_STATUS_UNTREATED  = 0; //未处理
    public static final Integer TODO_RECORD_STATUS_UNFINISHED = 1; //未完成
    public static final Integer TODO_RECORD_STATUS_FINISHED   = 2; //已完成
    //周边动态消息状态
    public static final Integer SURROUND_STATE_NOT = 0; //无效
    public static final Integer SURROUND_STATE_YES = 1; //有效

    //签约代表人首选状态
    public static final Integer AGENT_ISDFDEFCHOICE_NOT = 0; //非首选
    public static final Integer AGENT_ISDFDEFCHOICE_YES = 1; //首选

    //评估文件物业关系状态
    public static final Integer FILE_AESPRO_ACCESS_NOT          = 0; //无效
    public static final Integer FILE_AESPRO_ACCESS_YES          = 1; //有效
    public static final Integer FILE_AESPRO_ACCESS_UNCOMMITTED  = 2; //未提交
    public static final Integer FILE_AESPRO_ACCESS_TOAUDIT      = 3; //待审核

    //评估文件状态
    public static final Integer FILE_ACCESS_UNENABLE        = 0; //待启用
    public static final Integer FILE_ACCESS_NORMAL          = 1; //正常
    public static final Integer FILE_ACCESS_SCHEEDULE       = 2; //临期
    public static final Integer FILE_ACCESS_EXPIRE          = 3; //到期
    public static final Integer FILE_ACCESS_INVALIDATION    = 4; //提前终止
    public static final Integer FILE_ACCESS_UNCOMMITTED     = 5; //未提交
    public static final Integer FILE_ACCESS_TOAUDIT         = 6; //待审核
    public static final Integer FILE_ACCESS_NOPASS          = 7; //审核未通过

    //新增评估文件入口
    public static final Integer FILE_ACCESS_ADDFROM_NOT = 0; //不区分来源(静态已经通过审核)
    public static final Integer FILE_ACCESS_ADDFROM_PRO = 1; //物业新增
    public static final Integer FILE_ACCESS_ADDFROM_CER = 2; //管理界面新增


    //文件路径状态
    public static final Integer ATTACH_FILE_LIBRARY_NOT = 0; //无效
    public static final Integer ATTACH_FILE_LIBRARY_YES = 1; //有效

    //物业证件文件状态
    public static final Integer FILE_STATE_NOT = 0; //无效
    public static final Integer FILE_STATE_YES = 1; //有效

    //审批记录数据源划分
    public static final Integer DATA_APPROVAL_PROPERTY      = 1; //物业信息
    public static final Integer DATA_APPROVAL_TENANCY       = 2; //出租合同
    public static final Integer DATA_APPROVAL_ENTRUST       = 3; //委托合同
    public static final Integer DATA_APPROVAL_ACCESSCER     = 4; //评估文件

    //委托协议类型 entrust.type = {"1":"物业移交协议书","2":"物业委托管理协议书","3":"国有资产划转协议","4":"通用但无记录产权单位"}
    public static final Integer ENTRUST_TYPE_NORMAL         = 0; //通用合同
    public static final Integer ENTRUST_TYPE_TRANSFER       = 1; //物业移交协议书
    public static final Integer ENTRUST_TYPE_MANAGE         = 2; //物业委托管理协议书
    public static final Integer ENTRUST_TYPE_STATE_OWNED    = 3; //国有资产划转协议
    public static final Integer ENTRUST_TYPE_NON_OWNED      = 4; //通用但无记录产权单位

    //CONTRACT_PARTY ——CP 合同关系方信息来源 1：出租合同(产权方|甲方)，2：物业移交协议书，3：物业委托管理协议书，4：国有资产划转协议',
    public static final Integer CP_DATAFROM_TEN             = 1; //出租合同(产权方|甲方)
    public static final Integer CP_DATAFROM_TRANSFER        = 2; //物业移交协议书
    public static final Integer CP_DATAFROM_MANAGE          = 3; //物业委托管理协议书
    public static final Integer CP_DATAFROM_STATE_OWNED     = 4; //国有资产划转协议
    public static final Integer CP_DATAFROM_ENTRUST         = 5; //委托合同(签约代表)


    //CONTRACT_PARTY ——CP 关系方在合约中的角色类型，0：鉴证方，1：甲方(出租合同中为非正式"产权方")，2：乙方，3：丙方',
    public static final Integer CP_ROLE_TYPE_AUTH           = 0; //鉴证方1
    public static final Integer CP_ROLE_TYPE_AUTH_2         = 4; //鉴证方2
    public static final Integer CP_ROLE_TYPE_AUTH_3         = 5; //鉴证方3
    public static final Integer CP_ROLE_TYPE_FIRST          = 1; //甲方(出租合同中为非正式"产权方")
    public static final Integer CP_ROLE_TYPE_SECOND         = 2; //乙方
    public static final Integer CP_ROLE_TYPE_THIRD          = 3; //丙方

    //物业报修过程状态
    public static final Integer REPAIR_REPORT_TOAUDIT       = 1; //(租户)已上报审核中 | (物管)待审核申请
    public static final Integer REPAIR_REPORT_RETURN        = 2; //(租户)已退回 | (物管)已退回
    public static final Integer REPAIR_REPORT_REPAIR        = 3; //(租户)维修中：使用下方repairState的状态进行判断区分
    public static final Integer REPAIR_REPORT_COMPLETED     = 4; //(租户)维修完成 | (物管和维修单位)维修单汇总待结算(未结算|已结算)
    //物业维修中拆分状态
    public static final Integer REPAIR_STATE_RETURN              = 0; //物管操作退回，此时由维修单位操作
    public static final Integer REPAIR_STATE_SURVEY_AWAIT        = 1; //(租户)维修中 | (物管和维修单位)待查勘
    public static final Integer REPAIR_STATE_WORKLOAD_AWAITSUBMIT= 2; //(租户)维修中 | (物管和维修单位)待提交维修表
    public static final Integer REPAIR_STATE_WORKLOAD_TOAUDIT    = 3; //(租户)维修中 | (物管和维修单位)待审核维修表
    public static final Integer REPAIR_STATE_INSPECT_AWAITSUBMIT = 4; //(租户)维修中 | (物管和维修单位)待提交维修完成验收表
    public static final Integer REPAIR_STATE_INSPECT_TOAUDIT     = 5; //(租户)维修中 | (物管和维修单位)待审核维修完成验收表
    public static final Integer REPAIR_STATE_INSPECT_COMPLETED   = 6; //(租户)维修完成 | (物管和维修单位)审核维修完成验收表'

    //审核的报告类型
    public static final Integer REPAIR_REPORTETYPE_REPORT       = 1; //租户提交的报修申请
    public static final Integer REPAIR_REPORTETYPE_WORKLOAD     = 2; //维修单位提交的维修工程量信息表
    public static final Integer REPAIR_REPORTETYPE_INSPECT      = 3; //维修单位提交的验收表

    //物业报修 审核是否通过
    public static final Integer REPAIR_ASSIGNSTATUS_UNENABLE    = 0;//无效
    public static final Integer REPAIR_ASSIGNSTATUS_ENABLE      = 1;//有效

    //物管审核人职位类型，1：物管经办人，2：部门经理，3：项目部经理',4、预算及法务经理，5、甲方参与现场验收人员(物管经办人)，6、施工方(维修单位)
    public static final Integer REPAIR_APPROVAL_WGJBR      = 1; //物管经办人
    public static final Integer REPAIR_APPROVAL_BMJL       = 2; //部门经理
    public static final Integer REPAIR_APPROVAL_XMBJL      = 3; //项目部经理
    public static final Integer REPAIR_APPROVAL_YSJFWJL    = 4; //预算及法务经理
    public static final Integer REPAIR_APPROVAL_JFYS       = 5; //甲方参与现场验收人员(物管经办人)
    public static final Integer REPAIR_APPROVAL_WXDW       = 6; //施工方(维修单位)

    //报修节点审核状态 0：未通过，1：已通过，2：审核中',
    public static final Integer REPAIR_POINT_APPRSTATE_NOPASS      =       0;
    public static final Integer REPAIR_POINT_APPRSTATE_PASS        =       1;
    public static final Integer REPAIR_POINT_APPRSTATE_APPROVALING =       2;

    //物业报告指派维修关系
    public static final Integer REPAIR_ASSIGN_NOT          = 0; //无效
    public static final Integer REPAIR_ASSIGN_YES          = 1; //有效

    //E签宝流程状态 (E签宝返回)，流程状态，0：草稿，1：完成，2：签署中，3：撤销，4：终止，5：过期，6：删除，7：拒签
    public static final Integer ESIGN_FLOW_UNCOMMITTED      = 0; //草稿
    public static final Integer ESIGN_FLOW_ACHIEVE          = 1; //完成
    public static final Integer ESIGN_FLOW_SIGNING          = 2; //签署中
    public static final Integer ESIGN_FLOW_REPEAL           = 3; //撤销
    public static final Integer ESIGN_FLOW_BREAK            = 4; //终止
    public static final Integer ESIGN_FLOW_EXPIRE           = 5; //过期
    public static final Integer ESIGN_FLOW_DELETE           = 6; //过期
    public static final Integer ESIGN_FLOW_REFUSE           = 7; //拒签

    //E签宝签署状态
    public static final Integer ESIGN_FLOWMIS_AWAIT         = 1; //待签
    public static final Integer ESIGN_FLOWMIS_ACHIEVE       = 2; //完成
    public static final Integer ESIGN_FLOWMIS_DEFEATED      = 3; //失败
    public static final Integer ESIGN_FLOWMIS_REFUSE        = 4; //拒绝

    //E签宝所属
    public static final Integer ESIGN_FLOWMIS_IINI_NOT      = 0; //不是发起人
    public static final Integer ESIGN_FLOWMIS_IINI_YES      = 1; //是发起人

    //承租人类别
    public static final Integer RENTER_TYPE_PER             = 0;//个人
    public static final Integer RENTER_TYPE_CPY             = 1;//企业

    //公告状态
    public static final Integer NOTICE_NOT                  = 0; //无效
    public static final Integer NOTICE_YES                  = 1; //有效

    //报修 租户提交的评价状态，0：占位，1：满意，2：有待提高
    public static final Integer REPAIR_EVALUATE_PLAC        = 0;
    public static final Integer REPAIR_EVALUATE_SATISFIED   = 1;
    public static final Integer REPAIR_EVALUATE_INCREASE    = 2;

    public static final Integer STATUS_NO  = 0; //无效
    public static final Integer STATUS_YES = 1; //有效


    //押金表
    //押金(保证金)所属类型 1：出租合同，2：委托合同
    public static final Integer DEPTYPE_TEN                 =  1;
    public static final Integer DEPTYPE_ENT                 =  2;

    //收缴类型 1：收取，2：支出
    public static final Integer TRADETYPE_GATHER            =   1;
    public static final Integer TRADETYPE_EXPENDITURE       =   2;

    //押金返还状态 1：已返还，2：未返还,
    public static final Integer REFUNDTYPE_YETRETURN        =  1;
    public static final Integer REFUNDTYPE_NOYETRETURN      =  2;


    //批量导入报错提醒类型
    public static final Integer importStatus_success      = 1; //录入成功
    public static final Integer importStatus_fail_file    = -1; //录入失败，请检查文件和模板！
    public static final Integer importStatus_fail_sys     = -2; //系统异常，请联系管理员。
    public static final Integer importStatus_fail_format  = -3; //录入失败，以下数据或格式有误
    public static final Integer importStatus_fail_repeat  = -4; //录入失败，以下数据已存在
    public static final Integer importStatus_fail         = -5; //录入失败！未知原因。

    //分组有效||无效 0：无效,1：有效
    public static final Integer AUT_GROUP_STATUS_NO      =  0;
    public static final Integer AUT_GROUP_STATUS_YES     =  1;

}
