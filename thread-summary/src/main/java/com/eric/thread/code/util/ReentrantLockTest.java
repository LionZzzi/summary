package com.eric.thread.code.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Eric
 * @date 2020/2/17 0:04
 */
public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        // IntStream.range(0, 2).forEach(thread -> new Thread(ReentrantLockTest::lock, thread + " name").start());

        new Thread(() -> {
            unInterruptedLock();
        }).start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread = new Thread(() -> {
            unInterruptedLock();
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);

        lock.getHoldCount();
    }

    public static void lock() {
        lock.lock();
        try {
            System.out.println(System.currentTimeMillis() + "工作5秒" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis() + "结束工作" + Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public static void unInterruptedLock() {
        try {
            lock.lockInterruptibly();
            while (true) {

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
