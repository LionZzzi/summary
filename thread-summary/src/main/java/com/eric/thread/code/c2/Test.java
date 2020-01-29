package com.eric.thread.code.c2;

/**
 * @author Eric
 * @date 2020/1/30 0:24
 */
public class Test {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();

        Singleton1 instance1 = Singleton1.getInstance();

        Singleton2 instance2 = Singleton2.getInstance();

    }
}
