package com.nursery.coreJava.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <多把锁同时上锁,debug源码><br>
 *
 * @author jasonbrourne
 * @time 2023/1/29 10:41
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LockCase {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(()->{
            lock.lock();
        }).start();

        new Thread(()->{
            lock.lock();
        }).start();

        new Thread(()->{
            lock.lock();
        }).start();

        new Thread(()->{
            lock.lock();
        }).start();

        new Thread(()->{
            lock.lock();
        }).start();
    }
}
