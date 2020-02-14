package com.eric.thread.code.util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("等待玩家就绪");
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            new Thread(new StartGame(countDownLatch), "player-" + i).start();
        }
        countDownLatch.await();
        System.out.println("开始游戏");
    }

    static class StartGame implements Runnable {
        private CountDownLatch countDownLatch;

        public StartGame(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            Random random = new Random();
            int i = random.nextInt(5000);
            try {
                TimeUnit.MILLISECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "花费:" + i + "毫秒,准备就绪");
            countDownLatch.countDown();
        }
    }
}
