package com.nursery.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <循环依赖><br>
 *
 * @author jasonbrourne
 * @time 2023/2/28 21:03
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloCircularDependency {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleBean simpleBean = applicationContext.getBean("a", SimpleBean.class);
    }
}
