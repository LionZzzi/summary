package com.eric.thread.code.thread.bank;

/**
 * @author Eric
 * @date 2020/1/19 19:59
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("柜台一");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("柜台二");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("柜台三");
        ticketWindow3.start();
    }
}
