package com.nursery.coreJava.thread.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <Dispatch Pool><br>
 *
 * @author jasonbrourne
 * @time 2022/5/1 18:15
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DispatchPool {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

    private final NavigableSet<Task> dispatchPool = new ConcurrentSkipListSet<Task>((a, b) -> {
        return a.getPriority() - b.getPriority();
    });

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private static Integer LIMIT_SIZE = 5;

    /**
     * 调度任务进入
     *
     * @param taskProducer
     */
    public void dispatchIntoPool(TaskProducer taskProducer) {
        while (true) {
            lock.lock();
            try {
                while (dispatchPool.size() >= LIMIT_SIZE) {
                    condition.await();
                }
                while (!taskProducer.isEmpty() && dispatchPool.size() < LIMIT_SIZE) {
                    Task task = taskProducer.consume();
                    dispatchPool.add(task);
                }
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 消费任务
     */
    public void consumeTask(ResourceProducer resourceProducer) {
        while (true) {
            List<Task> consumedList = new ArrayList<>(7);
            lock.lock();
            try {
                while (dispatchPool.isEmpty()) {
                    condition.await();
                }
                Iterator<Task> it = dispatchPool.descendingIterator();
                while (it.hasNext()) {
                    Task task = it.next();
                    if (!resourceProducer.consume(task.getResourceNum()).isEmpty()) {
                        System.out.println("========任务执行begin=========");
                        doConsume(task, null);
                        System.out.println("========任务执行end===========");
                        consumedList.add(task);
                    }
                }
                dispatchPool.removeAll(consumedList);
                consumedList.clear();
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void doConsume(Task task, List<Resource> resources) {
        long beginTime = System.currentTimeMillis();
        // 执行任务
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成时间:" + dtf.format(LocalDateTime.now()));
        System.out.println("任务属性:" + task.toString());
        System.out.println("任务耗时:" + (System.currentTimeMillis() - beginTime) + "ms");
    }

    public String statistics() {
        return "DispatchPoolSize:" + dispatchPool.size() + ",idle:" + dispatchPool.size() / LIMIT_SIZE + "%";
    }
}
