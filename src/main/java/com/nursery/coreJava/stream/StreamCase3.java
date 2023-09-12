package com.nursery.coreJava.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * <stream流api结果流操作><br>
 *
 * @author jasonbrourne
 * @time 2023/9/9 16:44
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StreamCase3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 8, 2, 1, 6, 3, 5, 4, 8);
        // 求和1
        System.out.println(list.stream().reduce((x, y) -> x + y).get());
        // 求和2
        System.out.println(list.stream().reduce(Integer::sum).get());
        // 求和3
        System.out.println(list.stream().reduce(0, Integer::sum));
        // 求乘积
        System.out.println(list.stream().reduce((x, y) -> x * y).get());
        // 求最大值1
        System.out.println(list.stream().reduce((x, y) -> x > y ? x : y).get());
        // 求最大值2
        System.out.println(list.stream().reduce(1, Integer::max));

        // toList
        System.out.println(list.stream().collect(Collectors.toList()));
        // toSet
        System.out.println(list.stream().collect(Collectors.toSet()));
        // toSet
        System.out.println(
                list.stream().collect(Collectors.toMap(Function.identity(), Function.identity(), (x, y) -> x)));

        // 求总数
        System.out.println(list.stream().collect(Collectors.counting()));
        // 求平均
        System.out.println(list.stream().collect(Collectors.averagingInt(x -> x)));
        // 求最大值
        System.out.println(list.stream().collect(Collectors.maxBy(Integer::compareTo)).get());
        // 求和
        System.out.println(list.stream().collect(Collectors.summingInt(x -> x)));
        // 统计所有信息
        System.out.println(list.stream().collect(Collectors.summarizingDouble(x -> x)));

        // 按是否大于4分组
        System.out.println(list.stream().collect(Collectors.partitioningBy(x -> x > 4)));
        // 分组
        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity())));

        // 连接成字符串
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining("-")));

        // 是否都匹配
        System.out.println(list.stream().allMatch(x -> x > 0));
        // 是否都不匹配
        System.out.println(list.stream().noneMatch(x -> x > 0));
        // 是否有一个匹配
        System.out.println(list.stream().anyMatch(x -> x > 0));
        // 第一个元素
        System.out.println(list.stream().findFirst().get());
        // 任意元素
        System.out.println(list.stream().findAny().get());
        // 总个数
        System.out.println(list.stream().count());
        // 最大值
        System.out.println(list.stream().max(Integer::compareTo).get());
        // 最小值
        System.out.println(list.stream().min(Integer::compareTo).get());
    }
}
