package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/19 18:06
 */
public abstract class TemplateTest {
    public final void print(String message) {
        System.out.println("=======");
        warpPrint(message);
        System.out.println("=======");
    }
    public abstract void warpPrint(String message);

    public static void main(String[] args) {
        TemplateTest t1 = new TemplateTest() {
            @Override
            public void warpPrint(String message) {
                System.out.println("0" + message + "0");
            }
        };

        t1.print("dudu");
    }
}


