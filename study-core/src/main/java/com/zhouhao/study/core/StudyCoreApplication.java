package com.zhouhao.study.core;

import com.zhouhao.study.core.model.User;

public class StudyCoreApplication {

    public static void main(String[] args) {
        User a = new User();
        User b = new User();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

}
