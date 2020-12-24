package com.zhouhao.study.common.util;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtils {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ThreadPoolExecutor getDefaultThreadPoolExecutor(int n) {
        return new ThreadPoolExecutor(n, n, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    }

    public static void yield() {
        while (Thread.activeCount() > 2) {
//            System.out.println(Thread.activeCount());
            Thread.yield();
            sleep(1);
        }

        System.out.println("Process end.");
    }

    public static void currentExecute(int num, Runnable runnable) {
        for (int i = 0; i < num; i++) {
            new Thread(runnable).start();
        }
    }
}
