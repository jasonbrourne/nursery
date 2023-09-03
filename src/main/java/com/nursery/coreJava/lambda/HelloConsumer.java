package com.nursery.coreJava.lambda;

import java.util.function.Consumer;

/**
 * <Consumer测试><br>
 *
 * @author jasonbrourne
 * @time 2023/1/13 15:00
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloConsumer {

    public static void main(String[] args) {
        Consumer<Student> consumer = Student::getI;
    }

    class Student {
        private Integer i;

        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }
    }
}
