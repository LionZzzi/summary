package com.eric.thread.code.atomic;

import cn.hutool.core.collection.ConcurrentHashSet;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eric
 * @date 2020/2/7 23:17
 */
public class AtomicIntegerTest {

    private static AtomicInteger value = new AtomicInteger(1);
    private static ConcurrentHashSet set = new ConcurrentHashSet();
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            int x = 1;
            while (x <= 100) {
                int tmp = value.getAndIncrement();
                set.add(tmp);
                System.out.println(Thread.currentThread().getName() + "," + tmp);
                x++;
            }
        });
        Thread t2 = new Thread(() -> {
            int x = 1;
            while (x <= 100) {
                int tmp = value.getAndIncrement();
                set.add(tmp);
                System.out.println(Thread.currentThread().getName() + "," + tmp);
                x++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(set.size());
    }
}
