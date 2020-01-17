package com.eric.thread.code.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Eric
 * @date 2020/1/17 21:31
 */
public class NewThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new UseRun()).start();
        UseCall useCall = new UseCall();
        FutureTask<String> futureTask = new FutureTask<>(useCall);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        Thread thread = new Thread(new UseRun());
        thread.interrupt();
        thread.stop();
        thread.isInterrupted();
    }

    private static class UseRun implements Runnable {
        @Override
        public void run() {
            System.out.println("run");
        }
    }

    private static class UseCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "call";
        }
    }
}
