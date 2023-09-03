package com.nursery.coreJava.thread.stateTransition;

/**
 * <yield测试><br>
 *
 * @author jasonbrourne
 * @time 2022/3/3 16:06
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloYield {
    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (true) {
                if (i++ % 5 == 0) {
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
            }
        }).start();
        new Thread(() -> {
            int i = 0;
            while (true) {
                if (i++ % 5 == 0) {
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
            }
        }).start();
        new Thread(() -> {
            int i = 0;
            while (true) {
                if (i++ % 5 == 0) {
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
            }
        }).start();
    }
}
