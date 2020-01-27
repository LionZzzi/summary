package com.eric.thread.code.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Eric
 * @date 2020/1/27 18:22
 */
public class DeadThread {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        a.start();
        b.start();
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        synchronized (LockThread.LOCKA) {
            System.out.println("thread a lock a");
            synchronized (LockThread.LOCKB){
                System.out.println("thread a lock b");
            }
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        synchronized (LockThread.LOCKB) {
            System.out.println("thread b lock b");
            synchronized (LockThread.LOCKA){
                System.out.println("thread b lock a");
            }
        }
    }
}

class LockThread {
    public static final Object LOCKA = new Object();
    public static final Object LOCKB = new Object();
}
