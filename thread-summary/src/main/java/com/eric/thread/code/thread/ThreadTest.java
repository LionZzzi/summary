package com.eric.thread.code.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Eric
 * @date 2020/1/17 21:20
 */
@Slf4j
public class ThreadTest {

    private static void readFromDB() throws InterruptedException {
        log.info("===开始读取数据库===");
        Thread.sleep(10000);
        log.info("===数据库读取成功===");
    }

    private static void readFromFile() throws InterruptedException {
        log.info("===开始读取文件===");
        Thread.sleep(5000);
        log.info("===文件读取成功===");
    }

    public static void main(String[] args) {
        new Thread("my test thread") {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    log.info("task1 i:{}", i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


        for (int j = 0; j < 1000; j++) {
            log.info("task2 j:{}", j);
        }


//        new Thread(() -> {
//            try {
//                readFromDB();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                readFromFile();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

    }
}
