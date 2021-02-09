package com.zhouhao.study.core.se.keywords;

import com.zhouhao.study.common.util.ThreadUtils;
import org.junit.Ignore;
import org.junit.Test;

public class VolatileTest {

    private boolean status = false;
    private int a = 0;

    @Test
    public void testVisibility() {


    }

    @Test
    public void testOrderliness() {
        for (int i = 0; i < 100; i++) {
            System.out.println("loop " + i);
            new Thread(() -> {
                a = 1;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                status = true;
            }).start();

            new Thread(() -> {
                while (a == 0 && status) {
                    System.out.println("死循环");
                }
            }).start();

            ThreadUtils.yield();
        }
    }

}
