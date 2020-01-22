package com.eric.thread.code.thread.bank;

/**
 * @author Eric
 * @date 2020/1/19 19:59
 */
public class TicketWindow2 implements Runnable {

    private final static int MAX = 500;
    private int index = 1;

    @Override
    public void run() {
        while (true) {
            if (ticket()) {
                break;
            }
        }
    }

    public synchronized boolean ticket() {
        if (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + "当前号码:" + index++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
}
