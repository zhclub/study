package com.zhouhao.study.core.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private Integer age;

    private Date birthday;

}
