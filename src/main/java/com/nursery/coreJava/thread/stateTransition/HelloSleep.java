package com.nursery.coreJava.thread.stateTransition;

/**
 * <sleep测试><br>
 *
 * @author jasonbrourne
 * @time 2022/3/3 14:26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloSleep {
    private final static Object lock = new Object();

    public static void main(String[] args) {
        sleep();
    }

    /**
     * sleep进入睡眠不锁释放,结束睡眠进入Runnable状态
     */
    public static void sleep() {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
            synchronized (lock) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
        });
        System.out.println(t.getName() + "--" + Thread.currentThread().getState());
        t.start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
        }
    }
}
