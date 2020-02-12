package com.eric.thread.code.util;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Eric
 * @date 2020/2/12 22:22
 */
public class CountDownLatchTest1 {
    private static ExecutorService executor = Executors.newFixedThreadPool(3);
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        // 获取数据
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 多线程执行
        for (int i = 0; i < 10; i++) {
            executor.execute(new DoSth(data, i, countDownLatch));
        }
        countDownLatch.await();
        executor.shutdown();
        // 等待所有线程结束
        System.out.println("任务处理完成");
        System.out.println(Arrays.toString(data));
    }

    static class DoSth implements Runnable {

        private int[] data;
        private int index;
        private CountDownLatch countDownLatch;
        public DoSth(int[] data, int i, CountDownLatch countDownLatch) {
            this.data = data;
            this.index = i;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int temp = data[index];
            if (temp % 2 == 0) {
                data[index] = temp * 2;
            } else {
                data[index] = temp * 3;
            }
            System.out.println(Thread.currentThread().getName() + "- doing");
            countDownLatch.countDown();
        }
    }
}
