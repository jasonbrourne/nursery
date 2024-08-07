package com.nursery.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <1><br>
 *
 * @author jasonbrourne
 * @time 2022/3/11 18:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SpringCase {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleBean simpleBean = applicationContext.getBean("a", SimpleBean.class);
        System.out.println(simpleBean.getName());
        System.out.println(simpleBean.getAge());

        SimpleBean simpleBean2 = applicationContext.getBean("helloFactoryBean", SimpleBean.class);
        FactoryBean factoryBean = applicationContext.getBean("&helloFactoryBean", FactoryBean.class);
        ((ClassPathXmlApplicationContext) applicationContext).close();

        String a = "1";
        String b = "2";
        ObjectFactory d = new ObjectFactory<Object>() {
            @Override
            public Object getObject() throws BeansException {
                return getEarlyBeanReference(a, b);
            }
        };
        d.getObject();
    }

    public static Object getEarlyBeanReference(String a, String b){
        return "dd";
    }
}
