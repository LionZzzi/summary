package com.eric.thread.code.c2;

/**
 * 懒汉 (线程不安全)
 *
 * @author Eric
 * @date 2020/1/30 0:21
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {
        //do sth
    }

    public static Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
