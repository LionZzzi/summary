package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/20 22:12
 */
public class ThreadGroupT {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        });
        t2.setPriority(Thread.NORM_PRIORITY);
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        });
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
