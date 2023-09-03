package com.nursery.coreJava.collection.compare;

/**
 * <实体bean><br>
 *
 * @author jasonbrourne
 * @time 2022/2/24 17:45
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Person implements Comparable<Person>{

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.getAge();
    }
}
