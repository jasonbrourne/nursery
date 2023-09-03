package com.nursery.coreJava.thread.stateTransition;

/**
 * <A Simple Wait And Notify Operation><br>
 *
 * 1. wait、notify和notifyAll只能放到synchronized里面用
 * 2. 执行wait方法后释放锁
 *
 * @author jasonbrourne
 * @time 2022/4/10 23:48
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloWaitAndNotify {

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (HelloWaitAndNotify.class) {
                System.out.println(Thread.currentThread().getName() + " in");
                try {
                    HelloWaitAndNotify.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finish");
            }
        }).start();

        new Thread(() -> {
            synchronized (HelloWaitAndNotify.class) {
                System.out.println(Thread.currentThread().getName() + " in");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finish");
                HelloWaitAndNotify.class.notifyAll();
            }
        }).start();
    }
}
