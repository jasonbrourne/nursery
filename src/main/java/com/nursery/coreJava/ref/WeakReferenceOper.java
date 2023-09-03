package com.nursery.coreJava.ref;

import java.lang.ref.WeakReference;
import java.util.Collections;

/**
 * <弱引用><br>
 *
 * 不管什么情况，遇到GC就会回收被弱引用指向的对象
 *
 * @author jasonbrourne
 * @time 2022/2/20 17:50
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WeakReferenceOper {
    public static void main(String[] args) {
        WeakReference wr = new WeakReference(new T());
        System.out.println(wr.get());
        System.gc();
        System.out.println(wr.get());

        // 应用场景
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("hello");
        tl.remove();
    }
}
