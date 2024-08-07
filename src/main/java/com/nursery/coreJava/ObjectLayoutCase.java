package com.nursery.coreJava;

import org.openjdk.jol.info.ClassLayout;

/**
 * <1><br>
 *
 * @author jasonbrourne
 * @time 2022/3/9 16:45
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ObjectLayoutCase {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
