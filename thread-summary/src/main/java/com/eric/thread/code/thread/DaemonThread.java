package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/17 22:51
 */
public class DaemonThread {

    private static class UseDaemon extends Thread {
        public UseDaemon(String name) { 
            super(name);
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.println("thread name :" + Thread.currentThread().getName());
            }
            System.out.println("end :" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread deamon = new UseDaemon("daemon");
        deamon.setDaemon(true);
        deamon.start();
        Thread.sleep(5);
        //deamon.interrupt();
    }
}
