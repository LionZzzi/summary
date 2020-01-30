package com.eric.thread.code.c2;

/**
 * 高效的做法
 *
 * @author Eric
 * @date 2020/1/30 0:18
 */
public class Singleton5 {
    private Singleton5() {
        //do sth
    }

    private static class InstanceHolder {
        private static final Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return InstanceHolder.instance;
    }
}
