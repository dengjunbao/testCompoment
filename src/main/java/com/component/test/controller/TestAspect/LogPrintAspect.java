package com.component.test.controller.TestAspect;

/**
 * @Author: bao
 * @Date: 2020/3/31 22:15
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect//切面标记注解
@Component//springbean管理标记注解
public class LogPrintAspect{
    //自定义切点位置    
    //把切面连接点放在我们注解上    
    @Pointcut("execution(* com.component.test.controller.TestAspect.*.*(..))")
    private void controllerAspect(){}

    // 前置通知
    @Before("controllerAspect()")
    public void loginBefore(JoinPoint joinPoint) {

        // 我们从请求的上下文中获取request，记录请求的内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        System.out.println("请求路径 : " + request.getRequestURL());
        System.out.println("请求方式 : " + request.getMethod());
        System.out.println("方法名 : " + joinPoint.getSignature().getName());
        System.out.println("类路径 : " + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("参数 : " + Arrays.toString(joinPoint.getArgs()));



    }

    @AfterReturning(returning = "object", pointcut = "controllerAspect()")
    public void doAfterReturning(Object object) {

        System.out.println("方法的返回值 : " + object);
    }

    // 方法发生异常时执行该方法
    @AfterThrowing(throwing = "e",pointcut = "controllerAspect()")
    public void throwsExecute(JoinPoint joinPoint, Exception e) {

        System.err.println("方法执行异常 : " + e.getMessage());
    }

    // 后置通知
    @After("controllerAspect()")
    public void afterInform() {

        System.out.println("后置通知结束");
    }

    // 环绕通知
    @Around("controllerAspect()")
    public Object surroundInform(ProceedingJoinPoint proceedingJoinPoint) {

        System.out.println("环绕通知开始...");

        try {
            Object o =  proceedingJoinPoint.proceed();
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}