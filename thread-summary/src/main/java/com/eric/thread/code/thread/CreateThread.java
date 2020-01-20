package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/20 21:48
 */
public class CreateThread {
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error error) {
                    System.out.println(i);
                }
            }

            protected void add(int a) {
                i++;
                add(a++);
            }
        }, "thread1", 1024 * 1024 * 20).start();
    }
}
