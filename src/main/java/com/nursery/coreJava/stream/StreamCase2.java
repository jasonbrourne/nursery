package com.nursery.coreJava.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <stream中间流api操作><br>
 *
 * @author jasonbrourne
 * @time 2023/9/9 16:44
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StreamCase2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 1);
        // 过滤lambda表达式为false的元素
        System.out.println(list.stream().filter(s -> s < 5).collect(Collectors.toList()));
        // 获取前两位元素
        System.out.println(list.stream().limit(2).collect(Collectors.toList()));
        // 过滤重复元素
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
        // 跳过前2位元素
        System.out.println(list.stream().skip(2).collect(Collectors.toList()));

        // 将每个元素进行转换
        List<String> list2 = Arrays.asList("a,b,c", "1,2,3");
        System.out.println(list2.stream().map(s -> s.replace(",", "")).collect(Collectors.toList()));
        // 修改每个元素里面的值
        System.out.println(list2.stream().peek(s -> s.replace(",", "")).collect(Collectors.toList()));
        // 多维转为1维
        List<List<String>> list3 = Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("1", "2", "3"));
        System.out.println(list3.stream().flatMap(l -> l.stream()).collect(Collectors.toList()));

        // 排序
        List<Integer> list4 = Arrays.asList(7, 8, 2, 1, 6, 3, 5, 4);
        System.out.println(list4.stream().sorted(Comparator.comparing(Function.identity())).collect(Collectors.toList()));
        // 自定义排序
        System.out.println(list4.stream().sorted((o1, o2) -> o1 - o2).collect(Collectors.toList()));
        // Comparator.comparing().thenComparing()
    }
}
