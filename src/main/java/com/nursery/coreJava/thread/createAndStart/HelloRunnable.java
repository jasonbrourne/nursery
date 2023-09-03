package com.nursery.coreJava.thread.createAndStart;

/**
 * <runnable方式实现线程><br>
 *
 * @author jasonbrourne
 * @time 2023/1/16 17:12
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloRunnable {

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Runnable");
    }
}
