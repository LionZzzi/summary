package com.eric.thread.code.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric
 * @date 2020/2/7 0:59
 */
public class Simulator<T> {

    private final Map<Thread, T> map = new HashMap<>();

    public void set(T t) {
        synchronized (this){
            Thread thread = Thread.currentThread();
            map.put(thread, t);
        }
    }

    public T get() {
        synchronized (this){
            Thread thread = Thread.currentThread();
            return map.get(thread);
        }
    }

}
