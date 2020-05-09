package com.alibaba.study.threadpool;

import java.util.concurrent.*;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/6 9:48
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        get1();
    }

    public static void get1 () {
        /**
         * newSingleThreadExecutor 创建一个包含一个线程的线程池
         */
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);
        });

        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("尝试关闭线程执行器...");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("关闭任务被中断！");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("取消未完成的任务");
                executor.shutdownNow();
            }

            System.out.println("任务关闭完成");
        }


    }

    public static void get2 () {

    }
}
