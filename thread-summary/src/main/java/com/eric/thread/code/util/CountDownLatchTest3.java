package com.eric.thread.code.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Eric
 * @date 2020/2/12 22:22
 */
public class CountDownLatchTest3 {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
//            mainThread.interrupt();
        }).start();

        countDownLatch.await(1000, TimeUnit.MILLISECONDS);
        System.out.println("finished");
    }

}
