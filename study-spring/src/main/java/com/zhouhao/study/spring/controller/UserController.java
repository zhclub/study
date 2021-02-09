package com.zhouhao.study.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @GetMapping("/spring/get")
    public String get() {
        return "{\"success\":true}";
    }

}
