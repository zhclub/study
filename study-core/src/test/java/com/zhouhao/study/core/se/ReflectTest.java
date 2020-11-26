package com.zhouhao.study.core.se;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ReflectTest {

    @Test
    public void test() throws Exception {
        Class<User> userClass = User.class;

        // 获取空构造函数，修改访问权限，创建对象
        Constructor<User> constructor = userClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        User user = constructor.newInstance();

        // 获取私有方法，修改方法访问权限，执行方法
        Method say = userClass.getDeclaredMethod("say", String.class);
        say.setAccessible(true);
        Object result = say.invoke(user, "hello");
        assertEquals("hello.", result);

        // 获取私有变量，修改变量访问权限，为变量赋值
        Field name = userClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user, "test_name");
        assertEquals("test_name", user.getName());
    }

}

class User {

    private String name;

    private User() {

    }

    private User(String name) {
        this.name = name;
    }

    private String say(String message) {
        return message + ".";
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}