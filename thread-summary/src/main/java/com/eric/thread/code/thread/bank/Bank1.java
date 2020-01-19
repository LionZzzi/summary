package com.eric.thread.code.thread.bank;

/**
 * @author Eric
 * @date 2020/1/19 19:59
 */
public class Bank1 {
    public static void main(String[] args) {
        TicketWindow1 ticketWindow = new TicketWindow1();
        Thread thread1 = new Thread(ticketWindow,"1号柜台");
        Thread thread2 = new Thread(ticketWindow,"2号柜台");
        Thread thread3 = new Thread(ticketWindow,"3号柜台");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
