package com.nursery.coreJava.thread.executor;


import java.util.concurrent.*;

/**
 * <simpleCallable><br>
 *
 * @author jasonbrourne
 * @time 2022/3/3 20:57
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SimpleFuture<V> implements Runnable, Future {

    private Callable<V> callable;

    private V result;

    public SimpleFuture(Callable<V> callable) {
        this.callable = callable;
    }

    public SimpleFuture(Runnable runnable, V v) {
         this.callable = () -> {
             runnable.run();
             return v;
         };
    }

    @Override
    public void run() {
        try {
            this.result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        Thread.sleep(3000L);
        return result;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
