package com.nursery.coreJava.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <ThreadLoaclOper><br>
 *
 * @author jasonbrourne
 * @time 2022/3/6 23:25
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ThreadLocalCase {

    private static ThreadLocal<String> tl = new ThreadLocal<>();

    final static String ss = "1";

    public static void main(String[] args) throws InterruptedException {
        synchronized (ss){
            Thread.sleep(1000L);
        }
        Executor executor = Executors.newSingleThreadExecutor();
        tl.set("110");
        for (int i = 0; i < 9; i++) {
            synchronized (ss){
                Thread.sleep(1000L);
            }
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + tl.get());
                tl.set(String.valueOf(Math.random()));
                System.out.println(Thread.currentThread().getName() + tl.get());
            });
        }
        ((ExecutorService) executor).shutdown();
    }
}
