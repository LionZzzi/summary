package com.eric.thread.code.thread.stop;

/**
 * @author Eric
 * @date 2020/1/22 20:50
 */
public class TestStopThread {
    public static void main(String[] args) {
        StopThread thread = new StopThread();
        thread.execute(() -> {
            System.out.println("执行一个3秒的操作");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.shutdown(5000);
    }
}
