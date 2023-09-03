package com.nursery.coreJava.thread.lock;

import java.util.concurrent.Semaphore;

/**
 * <SemaphoreOper><br>
 *
 * @author jasonbrourne
 * @time 2022/3/6 21:19
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ":edn");
                    Thread.sleep(2000L);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
