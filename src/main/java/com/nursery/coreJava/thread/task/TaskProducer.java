package com.nursery.coreJava.thread.task;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <Task Producer><br>
 *
 * @author jasonbrourne
 * @time 2022/5/1 18:14
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TaskProducer {

    private LinkedBlockingQueue<Task> taskQueue = new LinkedBlockingQueue();

    /**
     * 生产任务
     *
     * @param task
     */
    public void produce(Task task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费任务
     *
     * @return
     */
    public Task consume() {
        return taskQueue.poll();
    }

    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }

    public String getQueueSize() {
        return "TaskQueueSize:" + taskQueue.size();
    }
}
