package com.nursery.coreJava.innerClass;

/**
 * <局部内部类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/19 23:14
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LocalClass {
}

class OuterClass1 {
    private String str = "str";

    public void func() {
        int i = 0;
        /**
         * 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内
         * 局部内部类就像是方法里面的一个局部变量一样，是不能有 public、protected、private 以及 static 修饰符的
         * 总结,局部内部类同局部变量
         */
        class InnerClass {
            public void hello() {
                System.out.println("hello");
            }

            private void say() {
                System.out.println("say");
                System.out.println(i);
                System.out.println(str);
            }
        }

        // 方法内部可以访问内部类所有方法和变量(包括私有)
        InnerClass ic = new InnerClass();
        ic.hello();
        ic.say();
    }
}
