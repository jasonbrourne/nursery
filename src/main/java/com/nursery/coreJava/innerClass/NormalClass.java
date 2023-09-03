package com.nursery.coreJava.innerClass;

/**
 * <普通内部类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/19 22:46
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NormalClass {

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass ic = oc.new InnerClass();
        ic.func();

        oc.callInner();
    }
}

/**
 * 外部类修饰符只能是默认的或者public
 */
class OuterClass {
    private Integer i = 0;

    private void say() {
        System.out.println("hello world");
    }

    public void callInner() {
        // 在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
        // 外部也可以访问到内部的私有变量和方法
        InnerClass ic = new InnerClass();
        ic.func();
        System.out.println(ic.i);
    }

    /**
     * 内部类可以拥有 private 访问权限、protected 访问权限、public 访问权限及包访问权限(权限控制与成员变量相同)
     * private 修饰，则只能在外部类的内部访问
     * public 修饰，则任何地方都能访问
     * protected 修饰，则只能在同一个包下或者继承外部类的情况下访问
     * 默认访问权限，则只能在同一个包下访问
     */
    class InnerClass {
        private Integer i = 1;

        public void func() {
            // 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
            System.out.println(i);
            say();

            // 当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。
            // 如果要访问外部类的同名成员，需要以下面的形式进行访问
            System.out.println(OuterClass.this.i);
        }
    }
}
