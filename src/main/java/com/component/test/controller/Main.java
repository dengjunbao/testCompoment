package com.component.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.component.test.model.Human;
import com.component.test.model.People;
import com.component.test.utils.StringUtils;
import com.monitorjbl.xlsx.StreamingReader;
import com.sun.javaws.CacheUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.StringUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.thymeleaf.util.DateUtils;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
/*    public static void main(String[] args) {
        int index = 1;
        int X = index++;
        System.out.println(++index);
        System.out.println(X);
        ShowIndex(index++);
        System.out.println(index);

    }

    public static void ShowIndex(int index) {
        System.out.println("ShowIndex:"+index);
    }*/

    @Test
    public void testLoad() throws Exception{
/*        FileInputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\宏源监管物业.xlsx");
        Workbook wk = StreamingReader.builder()
                .rowCacheSize(100)  //缓存到内存中的行数，默认是100
                .bufferSize(4096)  //读取资源时，缓存到内存的字节大小，默认是1024
                .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
        Sheet sheet = wk.getSheetAt(0);
        //遍历所有的行
        for (Row row : sheet) {
            //不读取前两行表头信息
            if (row.getRowNum() < 2){
                continue;
            }
            System.out.println("开始遍历第" + row.getRowNum() + "行数据：");
            //遍历所有的列
            for (Cell cell : row) {
                //不读取序号
                if (cell.getColumnIndex() == 0){
                    continue;
                }
                System.out.print(cell.getStringCellValue() + " ");
            }
            System.out.println(" ");
        }*/



/*        Object id = "1.0";
        Double id2 = Double.valueOf(String.valueOf(id));
        int id3 = id2.intValue();
        List<Integer> list = new ArrayList<Integer>();
        list.add(id3);
        list.add(2);
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        System.out.println(Arrays.toString(arr));*/

        /*long a = 1610812800;
        System.out.println(Math.toIntExact(a));*/


        String str = "档号序号物业租赁合同G11.013甲方(出租方):珠海市斗门区宏源资产经营有限公司乙方(承租方):梁家明本着互惠互利的原则,现就有关房屋租赁事宜,经甲乙双方协商一致,达成如下协议:一、租赁标的甲方将其管理的位于井岸镇井湾路700号的物业按公布的租赁底价、保证金明细表面积约19平方米,按现状租给乙方使用。二、租赁期限:租赁期三年,从2013年4月1日起至2016年3月31日止。三、租金及其支付方式:1、租金:从2013年4月16日起计收租金每月租金为人民币壹仟伍佰贰拾元正(小写￥1520.00元)。从第二年起租金在上年租金基数的基础上逐年递增5%2、租金支付方式:5月起每月十日前交当月租金,每延期1天加收违约金5%给甲方。3、乙方在租赁合同签订时必须以月租金的三倍预交履约保证金4560元。租赁期内乙方没有违反合同规定的,在合同期满后甲方将该保证金退还给乙方(凭保证金收据退款不计利息);如乙方在租赁期内违反合同规定的,乙方所交的保证金全额归甲方所有,乙方无权追回。四、管理和维修:1、甲方自租赁合同生效之日起30天内移交租赁标的物给乙方使用。2、合同终止时,乙方必须将标的物完整地移交给甲方,属于乙方配置的可动财产由乙方在终止合同前自行处置,并在5天之内交还标的物。不动资产、装修物等归甲方所有。未能如期交还时,甲方有权收回标的物,室内所有物资视作乙方弃物,归甲方所有和处理。3、甲方按现状把标的出租给乙方,乙方负责对租赁标的物业管理、日常维修保养及维护(如下水道、卷闸等);乙方如需对标的物进行改动时,需向甲方提交书面改动方案,经甲方审查同意后方能进行,否则视同违约,乙方并应赔偿甲方因此而产生的损失。4、甲方只按现状将标的物出租给乙方,租赁期间标的物潜在的漏水、渗水等原因给乙方造成的损失,由乙方自行承担。007";
        String str2 = "新档号序号物业租赁合同G11.014甲方(出租方):珠海市斗门区宏源资产经营有限公司乙方(承租方):黄海鹏本互惠互利的原则,现就有关房屋租赁事宜,经甲乙双方协商一致,达成如下协议:一、租赁标的:甲方将其管理的位于井岸井湾路700号的物业,按公布的租赁底价明细表面积约19平方米,按现状租给乙方使用二、租赁期限:租赁期五年,从2016年4月20日起至2021年3月19日止三、租金及其支付方式:1、租金:从2016年5月5日起计收租金,每月租金为人民币贰仟佰零伍元正(小写￥2705.00元)。从第二年起租金在上年租金基数的基础上逐年递增5%2、租金支付方式:5月起每月十日前交当月租金每延期1天加收违约金5%给甲方。3、乙方在租赁合同签订时必须以月租金的三倍预交履约保证金8115元租赁期内乙方没有违反合同规定的,在合同期满后甲方将该保证金退还给乙方(凭保证金收据退款不计利息)如乙方在租赁期内违反合同规定的乙方所交的保证金全额归甲方所有,乙方无权追回。四、管理和维修:1、甲方自租赁合同生效之日起30天内移交租赁标的物给乙方使用。2、合同终止时,乙方必须将标的物完整地移交给甲方,属于乙方配置的可动财产由乙方在终止合同前自行处置,并在5天之内交还标的物。不动资产、装修物等归甲方所有。未能如期交还时,甲方有权收回标的物,内所有物资视作乙方弃物,归甲方所有和处理。3、甲方按现状把标的出租给乙方,乙方负责对租赁标的物业管理、日常维修保养及维护(如下水道、卷闸等):乙方如需对标的物进行改动时,需向甲方提交书面改动方案,经甲方审查同意后方能进行,否则视同违约,乙方并应赔偿甲方因此而产生的损失。4、甲方只按现状将标的物出租给乙方,租赁期间标的物潜在的漏水、渗水等原因给乙方造成的损失,由乙方自行承担。1/2012";
        String regex = "年,从(.*?)止";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        Map m = new HashMap();
        m.put(null,"");
        while (matcher.find()) {
            System.out.println("matcher: " + matcher.group(0));
            System.out.println("matcher: " + matcher.group(1));
        }

/*        String z = "0";
        System.out.println(new BigDecimal(z));*/
        //System.out.println(chineseNumber2Int("十万九千七"));

/*        String s= "{'0':'605'}";
        Map occupyDataMap = JSONObject.parseObject(s, Map.class);
        int i =Integer.valueOf(occupyDataMap.get("0").toString());
        System.out.println(i);*/

/*        People people1 = new People();
        People people2 = new People();
        people1.setId(3);
        people1 = people2;
        String name = people2.getName();
        if (people2.getName() == null){
            System.out.println("name:null");
        }
        int nameLength = people2.getName().length();
        int nameLength2 = name.length();
        people1.setName("xiaohua");
        people2 = people1;
        System.out.println(people2);*/

/*        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);

        List list = new ArrayList();
        list.addAll(set);
        System.out.println(list);*/

/*        List list = new ArrayList<>();
        People people1 = new People();
        People people2 = new People();
        People people3 = new People();
        Human human = new Human();
        people2.setId(2);
        people2.setName("xiaohua");
        people3.setId(3);
        people3.setName("xiaohuang");
        BeanUtils.copyProperties(human,people3);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toArray());
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(list.toArray()).replace("[","(").replace("]",")"));*/

/*        Map<String,Object> remainTarget = new HashMap();
        remainTarget.put("0","超级管理员(宏源),录入员,审核员");
        List<String> roleNames = StringUtils.string2List(String.valueOf(remainTarget.get("0")));
        System.out.println(roleNames);
        String sql = String.format("roleName like '%s'",StringUtils.join(roleNames,","));
        System.out.println(sql);
        String remindTemplate = "提示信息:合同编号为%s，物业地址为%s的月租金将于%s递增为%s元";
        List<String> proNames = new ArrayList();
        proNames.add("珠海");
        proNames.add("深圳");
        proNames.add("广州");
        String date = "2020-01-01";
        String resPrice = "5000";
        String contentAll = fillTemplate(remindTemplate,"TestNo1", StringUtils.join(proNames,"、"),date,resPrice);*/

/*        Calendar c = Calendar.getInstance();
        Date date1 = c.getTime();
        c.setTime(new Date());
        Date date2 = c.getTime();
        c.add(Calendar.DATE, 7);  //设置当前时间为7天后
        Date date3 = c.getTime();
        c.clear();
        Date date4 = c.getTime();
        System.out.println(c.toString());*/

/*        Integer i = 13;
        System.out.println( i % 12);
        i = 15;
        System.out.println( i % 12);
        i = 17;
        System.out.println( i % 12);
        i = 20;
        System.out.println( i % 12);
        i = 23;
        System.out.println( i % 12);
        i = 24;
        System.out.println( i % 12);*/
/*        BigDecimal leaarea = new BigDecimal(0);
        BigDecimal proarea = new BigDecimal(20);
        leaarea = leaarea.intValue() == 0 ? proarea: leaarea;
        System.out.println(leaarea);*/



    }

    public String fillTemplate(String remindTemplate, String... param) {
        String contentAll = String.format(remindTemplate, param);
        return contentAll;
    }

    /**
     * 中文數字转阿拉伯数组【十万九千零六十  --> 109060】
     * @param chineseNumber
     * @return
     */
    @SuppressWarnings("unused")
    private static int chineseNumber2Int(String chineseNumber){
        int result = 0;
        int temp = 1;//存放一个单位的数字如：十万
        int count = 0;//判断是否有chArr
        char[] cnArr = new char[]{'一','二','三','四','五','六','七','八','九'};
        char[] chArr = new char[]{'十','百','千','万','亿'};
        for (int i = 0; i < chineseNumber.length(); i++) {
            boolean b = true;//判断是否是chArr
            char c = chineseNumber.charAt(i);
            for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
                if (c == cnArr[j]) {
                    if(0 != count){//添加下一个单位之前，先把上一个单位值添加到结果中
                        result += temp;
                        temp = 1;
                        count = 0;
                    }
                    // 下标+1，就是对应的值
                    temp = j + 1;
                    b = false;
                    break;
                }
            }
            if(b){//单位{'十','百','千','万','亿'}
                for (int j = 0; j < chArr.length; j++) {
                    if (c == chArr[j]) {
                        switch (j) {
                            case 0:
                                temp *= 10;
                                break;
                            case 1:
                                temp *= 100;
                                break;
                            case 2:
                                temp *= 1000;
                                break;
                            case 3:
                                temp *= 10000;
                                break;
                            case 4:
                                temp *= 100000000;
                                break;
                            default:
                                break;
                        }
                        count++;
                    }
                }
            }
            if (i == chineseNumber.length() - 1) {//遍历到最后一个字符
                result += temp;
            }
        }
        return result;
    }


}
