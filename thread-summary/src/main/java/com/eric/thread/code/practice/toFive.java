package com.eric.thread.code.practice;

/**
 * @author Eric
 * @date 2020/2/6 0:22
 */
public class toFive {
    private static Integer num = 0;
    private static final Integer MAX = 200;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num < MAX){
                System.out.println(Thread.currentThread().getName() + "->"+ ++num);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "s1").start();

        new Thread(() -> {
            while (num < MAX){
                System.out.println(Thread.currentThread().getName() + "->"+ ++num);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "s2").start();
    }
}
