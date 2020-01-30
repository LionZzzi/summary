package com.eric.thread.code.c2;

/**
 * 懒汉 (双重检验锁) 引发指令重排问题 空指针异常
 * 加个volatile即可解决
 * @author Eric
 * @date 2020/1/30 0:18
 */
public class Singleton4 {
    private Singleton4() {
        //do sth
    }

    // private static Singleton4 instance = null;
    private static volatile Singleton4 instance = null;


    public static Singleton4 getInstance() {
        if (null == instance) {
            synchronized (Singleton4.class) {
                if (null == instance) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
