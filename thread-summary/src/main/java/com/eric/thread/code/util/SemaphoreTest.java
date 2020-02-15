package com.eric.thread.code.util;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Eric
 * @date 2020/2/16 1:10
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-> run");
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "-> work");
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }).start();
        }
    }
}
