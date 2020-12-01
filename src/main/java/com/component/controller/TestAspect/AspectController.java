package com.component.controller.TestAspect;

import com.component.controller.TestAspect.testInterface.LogPrint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: bao
 * @Date: 2020/3/31 22:22
 */
@RestController
@RequestMapping("/testAspect")
public class AspectController {

    @LogPrint(desc = "属性描述")
    @Scheduled(cron = "0 0 0 1 0 0")
    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public String toIndex(){
        String str = "111111111111111";
        System.out.println(str);
        return "success";
    }
}
