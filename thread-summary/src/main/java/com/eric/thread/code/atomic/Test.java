package com.eric.thread.code.atomic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Eric
 * @date 2020/2/8 0:00
 */
public class Test {

    private static int integer = 0;

    public static void main(String[] args) throws InterruptedException {
        Set<Integer> set = new HashSet<>();
//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                int result = atomicInteger.addAndGet(1);
//                System.out.println(Thread.currentThread().getName()+","+result);
//            }
//        }).start();
//
//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                int result = atomicInteger.addAndGet(1);
//                System.out.println(Thread.currentThread().getName()+","+result);
//            }
//        }).start();


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                System.out.println(integer);
                integer++;
                set.add(integer);

            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                System.out.println(integer);
                integer++;
                set.add(integer);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("size:"+set.size());
    }
}
