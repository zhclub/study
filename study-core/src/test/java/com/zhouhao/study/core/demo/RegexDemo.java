package com.zhouhao.study.core.demo;

public class RegexDemo {

    public static void main(String[] args) {
        String s = "123";

        System.out.println(s.matches("[0-9, a-z]"));
    }

}
