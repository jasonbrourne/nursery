package com.nursery.coreJava.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * <BlockingQueue使用初识><br>
 *
 * @author jasonbrourne
 * @time 2023/1/18 8:39
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloBlockingQueue {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        new Thread(() -> {
            int i = 0;
            while (i++ < 10) {
                try {
                    queue.put(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
