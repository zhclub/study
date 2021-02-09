package com.zhouhao.study.spring.aop;

public class User {

    private String username;

    public String getUsername() {
        System.out.println("getUsername");
        return username;
    }

    public User setUsername(String username) {
        System.out.println("setUsername");
        this.username = username;
        return this;
    }
}
