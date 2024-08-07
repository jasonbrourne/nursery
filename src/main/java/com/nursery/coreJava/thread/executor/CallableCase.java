package com.nursery.coreJava.thread.executor;

import java.util.concurrent.*;

/**
 * <callable测试类><br>
 *
 * @author jasonbrourne
 * @time 2022/3/3 16:57
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CallableCase {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // helloCallable1();
        helloCallable2();
    }

    public static void helloCallable1() throws ExecutionException, InterruptedException {
        Future<String> future = new FutureTask<>(new MyCallable<>());
        new Thread((FutureTask) future).start();
        System.out.println(future.get());
    }

    public static void helloCallable2() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> future = es.submit(new MyCallable<>());
        System.out.println(future.get());
    }
}

class MyCallable<String> implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "：helloCallable");
        return (String) "nihao";
    }
}
