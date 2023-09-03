package com.nursery.coreJava.jvm.stack;

/**
 * <Slot重复使用测试><br>
 * <添加-verbose:gc 观察垃圾回收></>
 * @author jasonbrourne
 * @time 2022/7/31 20:54
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SlotReuseCase1 {

    /**
     * System.gc()回收了placeholder堆内存对象，
     * 说明placeholder的Slot已经交给a使用
     */
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
