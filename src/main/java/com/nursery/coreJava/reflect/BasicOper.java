package com.nursery.coreJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <基础操作><br>
 *
 * @author jasonbrourne
 * @time 2022/2/20 21:04
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BasicOper {

    public static void main(String[] args) throws Exception {
        Person person = new Person(10, "nihao");

        // 获取class的3中方式
        Class clazz1 = Class.forName("com.demo.coreJava.reflect.Person");
        Class clazz2 = Person.class;
        Class clazz3 = person.getClass();

        // 反射获取实例(类包含无参构造函数)
        Person person1 = (Person) clazz1.newInstance();
        System.out.println(person1.getName());
        // 反射获取实例(类不包含无参构造函数)
        Constructor constructor = clazz1.getConstructor(int.class, String.class);
        Person person2 = (Person)constructor.newInstance(10, "hello");
        System.out.println(person2.getName());

        // 操作成员变量
        Field field = person1.getClass().getDeclaredField("name");
        // 设为true才能访问私有变量
        field.setAccessible(true);
        System.out.println(field.get(person1));
        field.set(person1, "funking");
        System.out.println(person1.getName());

        // 操作方法
        Method method = person1.getClass().getDeclaredMethod("setName", String.class);
        method.invoke(person1, "method");
        Method method1 = person1.getClass().getDeclaredMethod("getName");
        System.out.println(method1.invoke(person1));
    }
}

class Person {

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {

    }

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
}
