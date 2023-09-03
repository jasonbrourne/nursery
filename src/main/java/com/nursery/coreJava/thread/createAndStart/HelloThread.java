package com.nursery.coreJava.thread.createAndStart;

/**
 * <继承Thread方式实现多线程><br>
 *
 * @author jasonbrourne
 * @time 2023/1/16 17:14
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloThread {
    public static void main(String[] args) {
        new MyThread().start();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello Thread");
    }
}
