package com.eric.thread.code.thread.demo;

/**
 * @author Eric
 * @date 2020/1/28 2:38
 */
public class One2Hundred {
    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        ThreadAA a = new ThreadAA(LOCK);
        ThreadBB b = new ThreadBB(LOCK);
        a.start();
        b.start();
    }
}

class ThreadAA extends Thread {
    private final Object lock;

    public ThreadAA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 1; i <= 100; i += 2) {
                lock.notify();
                System.out.println(i);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ThreadBB extends Thread {
    private final Object lock;

    public ThreadBB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 2; i <= 100; i += 2) {
                lock.notify();
                System.out.println(i);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}