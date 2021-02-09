package com.zhouhao.study.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;

/**
 * Bean实例化
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
 */
public class TestBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, BeanPostProcessor, InitializingBean, DisposableBean {

    private String name;

    public TestBean() {
        super();
        System.out.println("构造");
    }

    public String getName() {
        System.out.println("get");
        return name;
    }

    public TestBean setName(String name) {
        System.out.println("set");
        this.name = name;
        return this;
    }

    public void hello() {
        System.out.println("hello");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return bean;
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}
