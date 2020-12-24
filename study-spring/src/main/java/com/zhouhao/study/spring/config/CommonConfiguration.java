package com.zhouhao.study.spring.config;

import com.zhouhao.study.spring.model.User;
import com.zhouhao.study.spring.service.CommonService;
import com.zhouhao.study.spring.service.impl.CommonServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class CommonConfiguration {

    @Bean
    public CommonService commonService() {
        return new CommonServiceImpl();
    }

    @Bean
    public User user() {
        return new User();
    }

    @Resource
    private ApplicationContext applicationContext;

    @PostConstruct
    public void setUp() {
        Object user = applicationContext.getBean("user");

    }

}
