package com.eric.thread.code.util;

import java.util.concurrent.Exchanger;

/**
 * @author Eric
 * @date 2020/2/14 23:53
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                String result = exchanger.exchange("A发送的消息");
                System.out.println("从B获取的消息->" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                String result = exchanger.exchange("B发送的消息");
                System.out.println("从A获取的消息->" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
