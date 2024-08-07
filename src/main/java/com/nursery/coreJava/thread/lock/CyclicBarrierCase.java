package com.nursery.coreJava.thread.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <CyclicBarrierOper><br>
 *
 * @author jasonbrourne
 * @time 2022/3/6 21:03
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CyclicBarrierCase {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, ()->{
            System.out.println("to cyclicBarrier");
        });
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":edn");
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":edn");
        }).start();
    }
}
