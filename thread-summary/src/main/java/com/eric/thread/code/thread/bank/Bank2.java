package com.eric.thread.code.thread.bank;

/**
 * @author Eric
 * @date 2020/1/22 22:11
 */
public class Bank2 {
    public static void main(String[] args) {
        TicketWindow2 ticketWindow = new TicketWindow2();
        Thread thread1 = new Thread(ticketWindow,"1号柜台");
        Thread thread2 = new Thread(ticketWindow,"2号柜台");
        Thread thread3 = new Thread(ticketWindow,"3号柜台");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
