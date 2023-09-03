package com.nursery.coreJava.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <ReentrantReadWriteLock示例><br>
 *
 * @author jasonbrourne
 * @time 2023/1/30 14:50
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloReentrantReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock rrwLock = new ReentrantReadWriteLock();
        WriteThread wt1 = new WriteThread("wt1", rrwLock);
        ReadThread rt1 = new ReadThread("rt1", rrwLock);
        ReadThread rt2 = new ReadThread("rt2", rrwLock);
        wt1.start();
        rt1.start();
        rt2.start();
    }
}
class ReadThread extends Thread {
    private ReentrantReadWriteLock rrwLock;

    public ReadThread(String name, ReentrantReadWriteLock rrwLock) {
        super(name);
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying to lock");
        try {
            rrwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " lock successfully");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rrwLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}

class WriteThread extends Thread {
    private ReentrantReadWriteLock rrwLock;

    public WriteThread(String name, ReentrantReadWriteLock rrwLock) {
        super(name);
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying to lock");
        try {
            rrwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " lock successfully");
        } finally {
            rrwLock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}
