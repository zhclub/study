package com.zhouhao.study.core.se.keywords;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringTest {


    /**
     * String s = "hello";
     * JVM会现在常量池中查询字符串"hello"，如果找到了，会直接将s指向这个地址。如果找不到，会在常量池中开辟一块空间保存
     * 但是new String("hello")这种方式，jvm每次都会堆里重新创建一个对象。
     */
    @Test
    public void equals() {
        assertTrue("hello" == "hello");
        assertFalse(new String("hello") == "hello");
        assertFalse(new String("hello") == new String("hello"));
    }

}
