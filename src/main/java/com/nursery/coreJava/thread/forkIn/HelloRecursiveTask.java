package com.nursery.coreJava.thread.forkIn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * <RecursiveTask简单使用><br>
 *
 * @author jasonbrourne
 * @time 2023/2/1 14:06
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloRecursiveTask extends RecursiveTask<Integer> {
    private static final int THRESHHOLD = 2;
    private int start;
    private int end;

    public HelloRecursiveTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.println(start + " - " + end + " begin");
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHHOLD;
        if (canCompute) { // 达到了计算条件，则直接执行
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else { // 不满足计算条件，则分割任务
            int middle = (start + end) / 2;

            HelloRecursiveTask leftTask = new HelloRecursiveTask(start, middle);
            HelloRecursiveTask rightTask = new HelloRecursiveTask(middle + 1, end);

            leftTask.fork(); // 执行子任务
            rightTask.fork();
            int leftResult = leftTask.join(); // 等待子任务执行完毕
            int rightResult = rightTask.join();
            sum = leftResult + rightResult; // 合并子任务的计算结果
        }
        System.out.println(start + + end + " end");
        return sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = new ForkJoinPool();
        HelloRecursiveTask task = new HelloRecursiveTask(1, 8);
        Future<Integer> future = pool.submit(task);
        if (task.isCompletedAbnormally()) {
            System.out.println(task.getException());
        } else {
            System.out.println("result: " + future.get());
        }
    }
}
