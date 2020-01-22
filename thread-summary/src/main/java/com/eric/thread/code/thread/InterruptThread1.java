package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/21 22:33
 */
public class InterruptThread1 {
    public static final Object object = new Object();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                    System.out.println("do aaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();

        Thread b = new Thread(() -> {
            synchronized (object){
                try {
                    Thread.sleep(1000);
                    object.notify();
                }catch (Exception e){

                }

            }
        });
        b.start();
        System.out.println(a.isAlive());
    }
}
