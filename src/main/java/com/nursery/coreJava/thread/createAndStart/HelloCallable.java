package com.nursery.coreJava.thread.createAndStart;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <实现Callable方式来实现多线程><br>
 *
 * @author jasonbrourne
 * @time 2023/1/16 17:18
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        new Thread(futureTask).start();
        System.out.println("main is running");
        System.out.println("main:" + futureTask.get());
    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String hello = "hello Callable";
        System.out.println(hello);
        Thread.sleep(1000L);
        return hello;
    }
}
