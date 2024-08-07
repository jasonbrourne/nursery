package com.nursery.coreJava;

/**
 * <clone测试><br>
 *
 * @author jasonbrourne
 * @time 2022/2/20 16:10
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CloneCase {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        /**
         * clone复制为浅拷贝(成员只拷贝引用地址)
         */
        Person p1 = (Person) p.clone();
        System.out.println(p == p1);
        System.out.println(p1.getAge() == p.getAge());
        System.out.println(p1.getName() == p.getName());
    }
}

/**
 * 重写clone方法必须实现Cloneable接口
 */
class Person implements Cloneable {

    private int age = 10;

    private String name = "json";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
