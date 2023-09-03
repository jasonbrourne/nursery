package com.nursery.coreJava.collection;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * <map操作类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/24 11:46
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MapValuesOper {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(10);
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        Collection<String> collection = map.values();
        collection.forEach((c) -> {
            System.out.println(c);
        });
    }
}
