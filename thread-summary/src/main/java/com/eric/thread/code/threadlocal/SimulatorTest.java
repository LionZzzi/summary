package com.eric.thread.code.threadlocal;

/**
 * @author Eric
 * @date 2020/2/7 1:01
 */
public class SimulatorTest {

    private final static Simulator<String> threadLocal = new Simulator<>();

    public static void main(String[] args) {
        new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
                System.out.println(threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
                System.out.println(threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
