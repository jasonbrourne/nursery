package com.nursery.coreJava;

import java.util.ArrayList;
import java.util.List;

/**
 * <数组操作><br>
 *
 * @author jasonbrourne
 * @time 2022/2/18 22:44
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ArrayOperator {
    public static void main(String[] args) {
        // 初始化
        String[] ss = new String[10];

        // 初始化并赋值
        String[] si = {"a", "b"};

        // list转数组
        List<String> l = new ArrayList<>();
        String[] so = l.toArray(new String[l.size()]);
    }
}
