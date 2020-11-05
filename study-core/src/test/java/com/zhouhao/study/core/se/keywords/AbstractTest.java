package com.zhouhao.study.core.se.keywords;

public abstract class AbstractTest {

    int a;

    abstract void fun1();

    public void fun2() {
        System.out.println("fun2");
    }

    public AbstractTest(int a) {
        this.a = a;
    }

    public static void main(String[] args) {

    }

}
