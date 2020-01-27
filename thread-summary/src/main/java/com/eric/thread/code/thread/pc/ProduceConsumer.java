package com.eric.thread.code.thread.pc;

/**
 * @author Eric
 * @date 2020/1/27 20:39
 */
public class ProduceConsumer {

    private int i = 0;
    private final Object LOCK = new Object();
    private volatile boolean isProduce = false;

    public void produce() {
        synchronized (LOCK) {
            if (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("p生产一个 -> " + ++i);
                LOCK.notify();
                isProduce = true;
            }
        }
    }

    public void consumer() {
        synchronized (LOCK) {
            if (isProduce){
                System.out.println("c消费一个 -> " + i);
                LOCK.notify();
                isProduce = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumer produceConsumer = new ProduceConsumer();
        new Thread(() -> {
            while (true) {
                produceConsumer.produce();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                produceConsumer.consumer();
            }
        }).start();
    }
}
