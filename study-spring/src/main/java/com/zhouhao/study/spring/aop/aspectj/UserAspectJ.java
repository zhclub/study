package com.zhouhao.study.spring.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class UserAspectJ {

    @Pointcut("execution(* com.zhouhao.study.spring.aop.User.*(..))")
    public void point() {}

    @Before("point()")
    public void auth() {
        System.out.println("auth");
    }

    @Around("point()")
    public Object log(ProceedingJoinPoint pjp) {
        System.out.println("start log");
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("end log");
        return result;
    }
}
