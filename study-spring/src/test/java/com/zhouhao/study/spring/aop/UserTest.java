package com.zhouhao.study.spring.aop;

import com.zhouhao.study.spring.aop.aspectj.AopConfiguration;
import com.zhouhao.study.spring.aop.native1.InterceptorConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class UserTest {

    @Test
    public void testAspectJ() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfiguration.class);

        User user = applicationContext.getBean("user", User.class);
        print(user);
    }

    @Test
    public void testNative() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(InterceptorConfiguration.class);

        User user = applicationContext.getBean(User.class);
        print(user);
    }

    private void print(User user) {
        user.setUsername("name");
        System.out.println("---------");
        user.getUsername();
    }
}