package com.eric.thread.code.c2;

/**
 * 饿汉 (线程安全)
 *
 * @author Eric
 * @date 2020/1/30 0:18
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
        //do sth
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
