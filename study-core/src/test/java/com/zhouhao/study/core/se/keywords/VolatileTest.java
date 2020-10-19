package com.zhouhao.study.core.se.keywords;

import com.zhouhao.study.common.util.ThreadUtils;
import org.junit.Test;

public class VolatileTest {

    private boolean status = false;
    private int a = 1;

    @Test
    public void testVisibility() {


    }

    @Test
    public void testOrderliness() {

        new Thread(() -> {
            a = 2;
            status = true;
        }).start();

        new Thread(() -> {
            if (status) {
                System.out.println(a + 1);
            }
        }).start();

        ThreadUtils.yield();
    }

}
