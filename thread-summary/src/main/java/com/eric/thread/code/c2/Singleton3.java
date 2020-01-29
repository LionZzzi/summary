package com.eric.thread.code.c2;

/**
 * 懒汉 (加锁, 线程安全)
 *
 * @author Eric
 * @date 2020/1/30 0:21
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
        //do sth
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dududu222");
    }

    public synchronized static Singleton3 getInstance() {
        if (null == instance) {
            instance = new Singleton3();
        }
        return instance;
    }
}
