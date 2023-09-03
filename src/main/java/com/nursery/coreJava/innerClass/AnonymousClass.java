package com.nursery.coreJava.innerClass;

/**
 * <匿名内部类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/19 23:26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AnonymousClass {

    public static void main(String[] args) {
        new AnonymousClass().test(10);
    }


    public void test(int j) {
        int i = 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
                System.out.println(j);
            }
        }).start();
    }
}
