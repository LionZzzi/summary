package com.eric.thread.code.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Eric
 * @date 2020/2/12 22:22
 */
public class CountDownLatchTest2 {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("准备数据");
            try {
                Thread.sleep(2000);
                System.out.println("数据准备好了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start();

        new Thread(() -> {
            System.out.println("初始化工作");
            try {
                Thread.sleep(1000);
                System.out.println("等待以上的数据准备完成");
                countDownLatch.await();
                System.out.println("数据准备完成,继续做其他工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        /**
         * await是否可以被多个线程使用
         */
        new Thread(() -> {
            try {
                System.out.println("测试await");
                countDownLatch.await();
                System.out.println("测试await完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.currentThread().join();
    }

}
