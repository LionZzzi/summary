package com.eric.thread.code.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Eric
 * @date 2020/2/17 0:04
 */
public class ReentrantLockTest {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
            lock.unlock();
    }
}
