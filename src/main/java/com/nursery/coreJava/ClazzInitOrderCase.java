package com.nursery.coreJava;

/**
 * <类初始化顺序验证><br>
 *
 * @author jasonbrourne
 * @time 2022/2/20 10:31
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ClazzInitOrderCase {
    
    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Father {
    // 静态方法块
    static {
        System.out.println("父静态方法块初始化");
    }
    // 静态属性
    private static String staticField = getStaticField();
    // 普通属性
    private String field = getField();
    // 构造函数
    public Father() {
        System.out.println("父构造函数初始化");
    }
    // 普通方法块
    {
        System.out.println(field);
        System.out.println("父普通方法块初始化");
    }


    public static String getStaticField() {
        System.out.println("父静态属性初始化");
        return "父staticField";
    }

    public static String getField() {
        System.out.println("父对象属性初始化");
        return "父field";
    }
}

class Son extends Father {

    // 静态属性
    private static String staticField = getStaticField();

    private int iii= 0;
    // 静态方法块
    static {
        System.out.println(staticField);
        System.out.println("子静态方法块初始化");
    }
    // 普通属性
    private String field = getField();
    // 普通方法块
    {
        System.out.println(field);
        System.out.println("子普通方法块初始化");
    }
    // 构造函数
    public Son() {
        System.out.println("子构造函数初始化");
    }

    public static String getStaticField() {
        System.out.println("子静态属性初始化");
        return "子staticField";
    }

    public static String getField() {
        System.out.println("子普通属性初始化");
        return "子field";
    }
}