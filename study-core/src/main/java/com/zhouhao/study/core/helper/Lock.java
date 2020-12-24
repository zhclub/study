package com.zhouhao.study.core.helper;

import com.zhouhao.study.common.util.ThreadUtils;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class Lock extends AbstractQueuedSynchronizer {

    private static final int arg = 1;

    public void lock() {
        acquire(1);
    }

    public boolean unlock() {
        return release(1);
    }

    @Override
    protected boolean tryAcquire(int arg) {
        int state = getState();
        if (state == 1) {
            return false;
        }

        return compareAndSetState(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        int state = getState();
        if (state == 0) {
            throw new RuntimeException("没有获取锁");
        }

        for (int i = 0; i < 3; i++) {
            if (compareAndSetState(1, 0)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Lock lock = new Lock();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "成功获取锁");
                    ThreadUtils.sleep(2);
                } finally {
                    if (lock.unlock()) {
                        System.out.println(Thread.currentThread().getName() + "成功释放锁");
                    }
                }
            }).start();
        }

        ThreadUtils.yield();
    }
}
