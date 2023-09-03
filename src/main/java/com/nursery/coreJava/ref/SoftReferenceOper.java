package com.nursery.coreJava.ref;

import java.lang.ref.SoftReference;

/**
 * <弱引用><br>
 * 设置参数-Xmx20M
 * 大对象的本地缓存(如图片)
 *
 *
 * @author jasonbrourne
 * @time 2022/2/20 17:00
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SoftReferenceOper {
    public static void main(String[] args) {
        SoftReference<byte[]> sr = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(sr.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sr.get());

        byte[] b = new byte[1024 * 1024 * 10];
        // 内存不够时回收软引用
        System.out.println(sr.get());
    }
}
