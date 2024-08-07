package com.nursery.coreJava.thread.future;

import java.util.concurrent.*;

/**
 * <First CompletableFuture><br>
 *
 * @author jasonbrourne
 * @time 2022/4/6 15:13
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println(Thread.currentThread().getName());
        CompletableFuture completableFuture = new CompletableFuture();
        completableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "hello";
        }, Executors.newFixedThreadPool(10)).thenApplyAsync(s -> {
            System.out.println(s);
            System.out.println(Thread.currentThread().getName());
            return "hello1";
        }).whenComplete((s, throwable) -> {
            System.out.println(s);
            System.out.println(Thread.currentThread().getName());
        }).get(1000, TimeUnit.MILLISECONDS);
    }
}
