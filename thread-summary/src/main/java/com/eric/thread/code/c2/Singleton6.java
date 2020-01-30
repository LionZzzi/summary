package com.eric.thread.code.c2;

/**
 * 高效的做法 枚举
 *
 * @author Eric
 * @date 2020/1/30 0:18
 */
public class Singleton6 {
    private Singleton6() {
        //do sth
    }

    private enum Singleton {
        /**
         * 实例
         */
        INSTANCE;
        private final Singleton6 instance;

        Singleton() {
            instance = new Singleton6();
        }

        public Singleton6 getInstance() {
            return instance;
        }
    }

    public static Singleton6 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
