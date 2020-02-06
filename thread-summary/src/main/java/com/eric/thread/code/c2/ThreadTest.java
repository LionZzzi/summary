package com.eric.thread.code.c2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eric
 * @date 2020/2/4 0:06
 */
public class ThreadTest {
    public static void main(String[] args) {
         AtomicInteger i = new AtomicInteger();
        new Thread(()->{
            i.set(10);
        });

        new Thread(()->{
            int j = i.get();
        });
    }
}
