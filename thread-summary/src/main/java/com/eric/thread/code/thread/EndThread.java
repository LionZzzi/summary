package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/17 21:55
 */
public class EndThread {

    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            while (!isInterrupted()) {
                System.out.println(thread.getName() + "go on");
            }
            System.out.println(thread.getName() + "end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new UseThread("end thread");
        thread.start();
        thread.interrupt();
    }
}
