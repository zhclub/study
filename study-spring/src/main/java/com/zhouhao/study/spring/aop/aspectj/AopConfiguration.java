package com.zhouhao.study.spring.aop.aspectj;

import com.zhouhao.study.spring.aop.User;
import com.zhouhao.study.spring.aop.native1.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@Configuration
//@EnableAspectJAutoProxy(exposeProxy = true)
public class AopConfiguration {

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public UserAspectJ userAspectJ() {
        return new UserAspectJ();
    }

}
