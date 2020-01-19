package com.eric.thread.code.thread.bank;

/**
 * @author Eric
 * @date 2020/1/19 19:59
 */
public class TicketWindow1 implements Runnable {

    private final static int MAX = 50;
    private int index = 1;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + "当前号码:" + index++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
