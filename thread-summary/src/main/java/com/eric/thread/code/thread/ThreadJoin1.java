package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/20 23:46
 */
public class ThreadJoin1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new CaptureData(), "t1");
        t1.start();

        System.out.println("main thread finished");
    }
}

class CaptureData implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " - finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
