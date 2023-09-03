package com.nursery.coreJava.thread.lock;

import java.util.concurrent.CountDownLatch;

/**
 * <CountDownLatchOper><br>
 *
 * @author jasonbrourne
 * @time 2022/3/6 20:54
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch cd = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            cd.countDown();
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cd.countDown();
        }).start();
        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
