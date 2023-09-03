package com.nursery.coreJava.basic;

/**
 * <父><br>
 *
 * @author jasonbrourne
 * @time 2023/6/9 15:17
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Father {

    private static String s = "Father";

    public Father() {
        System.out.println("this is father");
        System.out.println("hi" + s);
    }

    public Father(int i) {
        System.out.println("this is father " + i);
    }
    
    public static void staticM () {
        System.out.println("this is Father staticM");
    }

    static {
        System.out.println("this is father static");
    }
}
