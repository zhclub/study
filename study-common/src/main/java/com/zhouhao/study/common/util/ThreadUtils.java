package com.zhouhao.study.common.util;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtils {

    public static ThreadPoolExecutor getDefaultThreadPoolExecutor(int n) {
        return new ThreadPoolExecutor(n, n, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    }

    public static void yield() {
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("Process end.");
    }

}
