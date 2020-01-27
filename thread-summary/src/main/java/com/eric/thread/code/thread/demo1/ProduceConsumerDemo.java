package com.eric.thread.code.thread.demo1;

import java.util.stream.Stream;

/**
 * @author Eric
 * @date 2020/1/28 0:02
 */
public class ProduceConsumerDemo {
    private int i = 0;
    private final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            while (i > 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "的值为:" + i + ",wait了");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName() + "被唤醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ++i;
            System.out.println(Thread.currentThread().getName() + "加" + i);
            LOCK.notifyAll();
        }
    }

    public void consumer() {
        synchronized (LOCK) {
            while (i <= 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "的值为:" + i + ",wait了");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName() + "被唤醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            --i;
            System.out.println(Thread.currentThread().getName() + "减" + i);
            LOCK.notifyAll();

        }
    }

    public static void main(String[] args) {
        ProduceConsumerDemo demo = new ProduceConsumerDemo();

        Stream.of("p1", "p2", "p3").forEach(d ->
                new Thread(() -> {
                    while (true) {
                        demo.produce();
                    }
                }, d).start());

        Stream.of("c1", "c2", "c3").forEach(d ->
                new Thread(() -> {
                    while (true) {
                        demo.consumer();
                    }
                }, d).start());
    }
}
