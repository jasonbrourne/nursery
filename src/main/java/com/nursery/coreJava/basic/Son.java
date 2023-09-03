package com.nursery.coreJava.basic;

/**
 * <儿子><br>
 *
 * @author jasonbrourne
 * @time 2023/6/9 15:17
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Son extends Father {

    private static String s = "Son";

    public Son() {
        System.out.println("this is son");
        System.out.println("hi" + s);
    }

    static {
        System.out.println("this is son static");
    }

    public static void staticM () {
        System.out.println("this is Son staticM");
    }

    public static void main(String[] args) {
        Father s = new Son();
        s.staticM();
    }
}
