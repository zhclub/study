package com.zhouhao.study.core.se;

import com.zhouhao.study.common.util.ThreadUtils;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) {

    }

    @Test
    public void testCountDown() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                ThreadUtils.sleep(2);
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println("execute complete");
    }

    @Test
    public void testCyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("------完成一次任务------");
        });

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 到达栅栏A");
                    ThreadUtils.sleep(2);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " 冲破栅栏A");

                    ThreadUtils.sleep(1);

                    System.out.println(Thread.currentThread().getName() + " 到达栅栏B");
                    ThreadUtils.sleep(2);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " 冲破栅栏B");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        ThreadUtils.sleep(10);
    }

    @Test
    public void testCyclicBarrier2() {
        concurrentExecute(1);
        concurrentExecute(2);
        concurrentExecute(3);

        ThreadUtils.sleep(10);
    }

    private void concurrentExecute(int id) {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println(id + "处理完成"));

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(id);
                    ThreadUtils.sleep(3);
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    // todo 测试notify唤醒顺序
    @Test
    public void testWait() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            increase(1);
        }
        this.notify();
    }

    private synchronized int increase(int a) throws InterruptedException {
        this.wait(1000);
        return a + 1;
    }

    /**
     * 测试线程中止
     */
    @Test
    public void testStop() {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始执行");
            ThreadUtils.sleep(3);
            System.out.println("线程执行结束");
        });

        thread.start();
        ThreadUtils.sleep(2);
        thread.stop();

        ThreadUtils.yield();
    }

    @Test
    public void testInterrupt() {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始执行");
            ThreadUtils.sleep(3);
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程已被中断");
                return;
            }
            System.out.println("线程执行结束");
        });

        thread.start();
        ThreadUtils.sleep(2);
        thread.interrupt();

        ThreadUtils.yield();
    }

    @Test
    public void testInterrupt2() {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始执行");
            synchronized (this) {
                // 同步代码块中执行sleep，会导致线程进入TIME_WAITING状态。
                // 如果此时线程被interrupt，就会抛出InterruptedException
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程执行结束");
        });

        thread.start();
        ThreadUtils.sleep(1);
        thread.interrupt();

        ThreadUtils.yield();
    }
}

