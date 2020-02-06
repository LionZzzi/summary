package com.eric.thread.code.threadlocal;

/**
 * @author Eric
 * @date 2020/2/6 18:45
 */
public class Simple {
    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "eric");

    public static void main(String[] args) {
        System.out.println(threadLocal.get());
    }
}
