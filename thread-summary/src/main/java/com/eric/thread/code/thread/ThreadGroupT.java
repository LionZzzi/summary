package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/20 22:12
 */
public class ThreadGroupT {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("hello"));
        t.start();
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
    }
}
