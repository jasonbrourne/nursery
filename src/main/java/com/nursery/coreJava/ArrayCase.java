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
public class ArrayCase {
    public static void main(String[] args) {

        initArr();

        // list转数组
        List<String> l = new ArrayList<>();
        String[] so = new String[l.size()];
        String[] sos = l.toArray(so);
        System.out.println(so.equals(sos)); // true
    }

    public static void initArr() {
        // 初始化
        String[] ss = new String[10];

        // 初始化并赋值
        String[] si = { "a", "b" };

        System.out.println(ss);
        System.out.println(si[0]);
        System.out.println(si);
    }
}
