package com.eric.thread.code.thread.bank;

/**
 * @author Eric
 * @date 2020/1/19 19:59
 */
public class TicketWindow extends Thread {

    private final  static Object o = new Object();
    private static final int MAX = 500;
    private String name;
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (o){
                if (index > MAX) {
                    break;
                }
                System.out.println(name + "当前号码:" + index++);
            }
        }

    }
}
