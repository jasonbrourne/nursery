package com.nursery.coreJava.innerClass;

/**
 * <静态内部类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/20 9:58
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StaticClass {
    public static void main(String[] args) {
        OuterClass2.InnerClass oc = new OuterClass2.InnerClass();
        oc.hello();
    }
}

class OuterClass2 {
    
    private static Integer j = 9; 

    public void say(){
        InnerClass ic = new InnerClass();
        System.out.println(ic.i);
        ic.test();
    }

    /**
     * 静态内部类是不持有指向外部类对象的引用的
     */
    static class InnerClass {
        private Integer i = 1;

        private void test() {
            System.out.println(j);
            System.out.println("test");
        }

        public void hello(){
            System.out.println("hello");
        }
    }
}
