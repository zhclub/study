package com.zhouhao.study.core.demo;

import java.lang.reflect.Method;

public class RegexDemo {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.zhouhao.study.core.demo.RegexDemo");

        Method test = aClass.getMethod("test", Integer.class);
        Object o = aClass.newInstance();


        test.invoke(o, 1);
    }


    public void test(int a) {
        System.out.println(a);
    }

}
