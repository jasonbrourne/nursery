package com.nursery.coreJava.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <HelloReentrantReadWriteLock测试><br>
 *
 * @author jasonbrourne
 * @time 2023/1/30 17:14
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ReentrantReadWriteLockCase2 {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        new Thread(()->{
            lock.writeLock().lock();
            System.out.println("get write lock");
            lock.readLock().lock();
            System.out.println("get read lock");
            lock.writeLock().unlock();
            System.out.println("release write lock");
            lock.readLock().unlock();
            System.out.println("release read lock");
        }).start();
    }
}
