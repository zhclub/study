package com.zhouhao.study.spring.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TestBeanTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        TestBean testBean = applicationContext.getBean(TestBean.class);
        testBean.hello();
    }

}