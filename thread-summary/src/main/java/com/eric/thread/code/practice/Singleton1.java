package com.eric.thread.code.practice;

/**
 * @author Eric
 * @date 2020/1/31 22:36
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
        // do sth
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
