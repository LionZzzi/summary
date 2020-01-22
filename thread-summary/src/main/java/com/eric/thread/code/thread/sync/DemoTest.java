package com.eric.thread.code.thread.sync;

/**
 * @author Eric
 * @date 2020/1/22 23:26
 */
public class DemoTest {
    public static void main(String[] args) {
        SyncTest1 test1 = new SyncTest1();
        new Thread("T1"){
            @Override
            public void run() {
                test1.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                test1.m2();
            }
        }.start();
    }
}

class SyncTest1 {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}