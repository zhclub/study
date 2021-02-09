package com.zhouhao.study.spring.aop.native1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class UserInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("*888csiadhfoihawf");
        Method method = methodInvocation.getMethod();
        System.out.println(method.getName());
        return methodInvocation.proceed();
    }

}
