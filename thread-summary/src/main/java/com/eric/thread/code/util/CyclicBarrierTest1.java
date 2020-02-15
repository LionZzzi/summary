package com.eric.thread.code.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author Eric
 * @date 2020/2/13 22:42
 */
public class CyclicBarrierTest1 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("T1 finished");
                cyclicBarrier.await();
                System.out.println("all finished");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("T2 finished");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(15);
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.isBroken());
    }
}
