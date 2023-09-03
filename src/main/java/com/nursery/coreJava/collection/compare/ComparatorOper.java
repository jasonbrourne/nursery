package com.nursery.coreJava.collection.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <Comparator测试><br>
 *
 * @author jasonbrourne
 * @time 2022/2/24 17:55
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ComparatorOper {
    public static void main(String[] args) {
        Person zhang3 = new Person("zhangsan", 3);
        Person li4 = new Person("lisi", 4);
        Person wang2 = new Person("wanger", 2);
        List<Person> list = new ArrayList<>();
        list.add(zhang3);
        list.add(li4);
        list.add(wang2);

        for (Person p : list) {
            System.out.println(p.getAge());
        }

        Collections.sort(list, (p1, p2)->{
            return p1.getAge() - p2.getAge();
        });

        for (Person p : list) {
            System.out.println(p.getAge());
        }
    }
}
