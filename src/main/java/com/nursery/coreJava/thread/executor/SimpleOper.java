package com.nursery.coreJava.thread.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <demo><br>
 *
 * @author jasonbrourne
 * @time 2022/3/3 21:36
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SimpleOper {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleExcutorService ses = new SimpleExcutorService();
        Future f = ses.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ":hello world");
            return "hihao";
        });
        System.out.println(Thread.currentThread().getName() + ":" + f.get());
    }
}
