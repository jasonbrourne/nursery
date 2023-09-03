package com.nursery.coreJava.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <Set操作><br>
 *
 * @author jasonbrourne
 * @time 2022/2/24 16:06
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SetOper {
    public static void main(String[] args) {
        // Set<String> set = new HashSet<>();
        Set<String> set = new LinkedHashSet<>();
        set.add("5");
        set.add("4");
        set.add("3");
        set.add("2");
        set.add("1");

        for (String str : set) {
            System.out.println(str);
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
