package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/21 21:48
 */
public class InterruptThread {
    private static final Object flag = new Object();

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        a.start();
        b.start();
    }

    static class ThreadA extends Thread {

        @Override
        public void run() {
            synchronized (flag) {
                for (int i = 1; i <= 100; i += 2) {
                    flag.notify();
                    System.out.println(i);
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (flag) {
                for (int i = 2; i <= 100; i += 2) {
                    flag.notify();
                    System.out.println(i);
                    try {
                        if (i != 100) {
                            flag.wait();
                        } else {
                            flag.notify();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


