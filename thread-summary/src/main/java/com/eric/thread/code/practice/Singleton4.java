package com.eric.thread.code.practice;

/**
 * @author Eric
 * @date 2020/1/31 22:36
 */
public class Singleton4 {

    private Singleton4() {

    }

    private static class InstanceHolder {
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return InstanceHolder.instance;
    }
}
