package com.nursery.coreJava.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * <虚引用><br>
 * 使用场景 管理堆外内存，jvm gc线程
 * <p>
 * 虚引用取不到值
 * <p>
 * 虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列（ReferenceQueue）联合使用。当垃圾回收器准备回收一个对象时，
 * 如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中
 *
 * @author jasonbrourne
 * @time 2022/2/20 19:29
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PhantomReferenceOper {

    private static final List<Object> LIST = new LinkedList<>();

    private static final ReferenceQueue<T> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<T> pr = new PhantomReference<>(new T(), QUEUE);
        /*pr.get();
        System.gc();
        pr.get();*/

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(pr.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends T> reference = QUEUE.poll();
                if (null != reference) {
                    System.out.println("虚引用被jvm回收");
                }
            }
        }).start();
    }
}
