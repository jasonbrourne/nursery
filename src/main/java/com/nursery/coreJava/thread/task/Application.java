package com.nursery.coreJava.thread.task;

import java.util.Random;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * <执行方法><br>
 *
 * @author jasonbrourne
 * @time 2022/5/1 18:45
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Application {

    public static void main(String[] args) {

        TaskProducer taskProducer = new TaskProducer();
        ResourceProducer resourceProducer = new ResourceProducer();
        DispatchPool dispatchPool = new DispatchPool();

        // Task Producer
        newSingleThreadExecutor().execute(() -> {
            for (int i = 0; ; i++) {
                try {
                    Thread.sleep(new Random().nextInt(200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                taskProducer.produce(new Task("task" + i, i, new Random().nextInt(10)));
            }
        });

        // Resource Producer
        newSingleThreadExecutor().execute(() -> {
            for (; ; ) {
                try {
                    Thread.sleep(new Random().nextInt(200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resourceProducer.produce();
            }
        });

        // 生成池
        newSingleThreadExecutor().execute(() -> {
            dispatchPool.dispatchIntoPool(taskProducer);
        });

        // 消费池
        newSingleThreadExecutor().execute(() -> {
            dispatchPool.consumeTask(resourceProducer);
        });

        // 监控
        newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===========监控begin==============");
                System.out.println(taskProducer.getQueueSize());
                System.out.println(resourceProducer.getPoolSize());
                System.out.println(dispatchPool.statistics());
                System.out.println("===========监控end================");
            }
        });
    }
}
