package com.nursery.coreJava.thread.task;

/**
 * <任务><br>
 *
 * @author jasonbrourne
 * @time 2022/5/1 18:12
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Task {

    private String name;

    private Integer priority;

    private Integer resourceNum;

    public Task(String name, Integer priority, Integer resourceNum) {
        this.name = name;
        this.priority = priority;
        this.resourceNum = resourceNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getResourceNum() {
        return resourceNum;
    }

    public void setResourceNum(Integer resourceNum) {
        this.resourceNum = resourceNum;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", resourceNum=" + resourceNum +
                '}';
    }
}
