package com.nursery.coreJava.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <lambda表达式><br>
 *
 * @author jasonbrourne
 * @time 2023/1/13 10:04
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LambdaCase {

    public static void main(String[] args) {

        List list = Lists.newArrayList("1","2","3");
        list.forEach(System.out::println);

        List l = (List)list.stream().filter(o-> "3".equals(o)).collect(Collectors.toList());
        l.forEach(System.out::println);
    }
}
