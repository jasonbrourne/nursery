package com.nursery.coreJava.thread.stateTransition;

/**
 * <join操作类><br>
 *
 * join表示当前线程等待t线程执行完,作用类似于 CountDownLatch。
 *
 * 调用Thread类的synchronized join方法,把Thread实例当做一个普通
 * 的对象，当前线程调用的Thread实例的wait方法，导致当前线程等待。
 * Thread在执行完run方法时,会自动调用Thread对象notifyall方法
 *
 * @author jasonbrourne
 * @time 2022/3/3 14:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class JoinCase {
    
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
    }
}
