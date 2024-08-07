package com.nursery.coreJava.thread.threadPool;

import java.util.concurrent.Executors;

/**
 * <CachedThreadPool使用><br>
 *
 * @author jasonbrourne
 * @time 2023/1/16 21:46
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CachedThreadPoolCase {
    public static void main(String[] args) {
        Executors.newCachedThreadPool().execute(System.out::println);
    }
}
