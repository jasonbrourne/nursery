package com.nursery.coreJava.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * <LockSupport使用><br>
 *
 * @author jasonbrourne
 * @time 2022/3/6 20:37
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LockSupportCase1 {

    public static void main(String[] args) {
        Object object = Thread.currentThread();
        Thread t = new Thread(() -> {
            System.out.println("before unpark");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取blocker
            System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
            // 释放许可
            LockSupport.unpark((Thread) object);
            // 休眠500ms，保证先执行park中的setBlocker(t, null);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 再次获取blocker
            System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));

            System.out.println("after unpark");
        });
        t.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
