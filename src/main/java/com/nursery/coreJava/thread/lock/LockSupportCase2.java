package com.nursery.coreJava.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * <多次park实验><br>
 *
 * @author jasonbrourne
 * @time 2023/1/29 16:33
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LockSupportCase2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            LockSupport.park();
            System.out.println("unpark 1");
            LockSupport.park();
            System.out.println("unpark 2");
        });
        t.start();
        LockSupport.unpark(t);
        Thread.sleep(1000L);
        LockSupport.unpark(t);
    }
}
