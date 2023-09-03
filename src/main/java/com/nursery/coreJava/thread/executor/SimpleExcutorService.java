package com.nursery.coreJava.thread.executor;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * <simpleExecutor><br>
 *
 * @author jasonbrourne
 * @time 2022/3/3 21:18
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SimpleExcutorService implements ExecutorService {

    private SimpleFuture simpleFuture;

    private SimpleFuture getSimpleFuture(Callable task) {
        SimpleFuture simpleFuture = new SimpleFuture(task);
        return simpleFuture;
    }

    private SimpleFuture getSimpleFuture(Runnable runnable, Object o) {
        SimpleFuture simpleFuture = new SimpleFuture(runnable, o);
        return simpleFuture;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        SimpleFuture simpleFuture = getSimpleFuture(task);
        execute(simpleFuture);
        return simpleFuture;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        SimpleFuture simpleFuture = getSimpleFuture(task, result);
        execute(simpleFuture);
        return simpleFuture;
    }

    @Override
    public Future<?> submit(Runnable task) {
        SimpleFuture simpleFuture = getSimpleFuture(task, null);
        execute(simpleFuture);
        return simpleFuture;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
