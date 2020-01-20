package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/20 23:20
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        });

        t1.start();
        t1.join();
        t2.start();
    }
}
