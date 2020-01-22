package com.eric.thread.code.thread.sync;

/**
 * @author Eric
 * @date 2020/1/22 21:54
 */
public class SyncTest {
    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(200000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
    }
}
