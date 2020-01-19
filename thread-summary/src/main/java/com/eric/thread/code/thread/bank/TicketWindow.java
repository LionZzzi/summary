package com.eric.thread.code.thread.bank;

/**
 * @author Eric
 * @date 2020/1/19 19:59
 */
public class TicketWindow extends Thread {

    private static final int MAX = 50;
    private String name;
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(name + "当前号码:" + index++);
        }

    }
}
