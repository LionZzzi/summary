package com.eric.thread.code.thread.stop;

/**
 * @author Eric
 * @date 2020/1/22 20:32
 */
public class StopThread {

    private Thread thread;

    public void execute(Runnable runnable) {
        thread = new Thread(() -> {
            Thread son = new Thread(runnable);
            son.setDaemon(true);
            son.start();
            try {
                son.join();
                thread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void shutdown(long estimatedTime) {
        long start = System.currentTimeMillis();
        while (!thread.isInterrupted()) {
            if (System.currentTimeMillis() - start >= estimatedTime) {
                System.out.println("已超出预估时间, 强制结束");
                thread.interrupt();
            }
        }
        System.out.printf("总共花费 -> %s", System.currentTimeMillis() - start);
    }
}
