package com.nursery.coreJava.thread.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <Resource Producer><br>
 *
 * @author jasonbrourne
 * @time 2022/5/1 18:15
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ResourceProducer {

    private LinkedBlockingQueue<Resource> resourcePool = new LinkedBlockingQueue();

    /**
     * 生产资源
     */
    public void produce() {
        try {
            resourcePool.put(new Resource());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费资源
     *
     * @param need
     * @return
     */
    public List<Resource> consume(int need) {
        List<Resource> resources = new ArrayList<>(need);
        if (suffice(need)) {
            resourcePool.drainTo(resources, need);
        }
        return resources;
    }

    /**
     * 是否满足资源需求
     *
     * @param need
     * @return
     */
    public boolean suffice(int need) {
        return resourcePool.size() >= need;
    }

    public String getPoolSize() {
        return "ResourcePoolSize:" + resourcePool.size();
    }
}
