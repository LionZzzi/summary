package com.eric.thread.code.thread;

/**
 * @author Eric
 * @date 2020/1/19 22:40
 */
public class ThreadT1 extends Thread {
    public ThreadT1(String s) {
        super(s);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "执行了");
    }

    private static int count = 0;

    public static void main(String[] args) {
        try {
            test(0);
        }catch (Error e){
            e.printStackTrace();
            System.out.println(count);
        }

    }

    public static void test(int i) {
        ++count;
        test(++i);
    }
}
