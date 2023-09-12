package com.nursery.coreJava.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * <创建流基本操作><br>
 *
 * @author jasonbrourne
 * @time 2023/9/9 16:14
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StreamCase1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] arr = { "redis", "nacos", "xxxjob", "apollo" };

        // Arrays
        Arrays.stream(arr).forEach(System.out::println);

        // collection
        Arrays.asList(arr).stream().forEach(System.out::println);
        Arrays.asList(arr).parallelStream().forEach(System.out::println);

        // stream流中静态方法
        Stream.of(arr).forEach(System.out::println);
        Stream.iterate(1, x -> x + 1).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        // BufferedReader
        BufferedReader br = new BufferedReader(new FileReader("D:\\ideaProject\\nursery\\.gitignore"));
        br.lines().forEach(System.out::println);

        // Pattern.splitAsStream()
        Pattern.compile(",").splitAsStream("a,b,c,d").forEach(System.out::println);
    }
}
