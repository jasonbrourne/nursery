package com.nursery.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PreDestroy;

/**
 * <简单的bean><br>
 *
 * @author jasonbrourne
 * @time 2022/3/11 19:14
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SimpleBean implements InitializingBean {

    private CircularDependencyBean circularDependencyBean;

    @Autowired
    public SimpleBean(CircularDependencyBean circularDependencyBean) {
        this.circularDependencyBean = circularDependencyBean;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("do initializingBean afterPropertiesSet method");
    }

    public void destroy() throws Exception {
        System.out.println("do destroy method");
    }

    public void destroyMethod() {
        System.out.println("do destroyMethod method");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println("do preDestroy method");
    }

    public CircularDependencyBean getCircularDependencyBean() {
        return circularDependencyBean;
    }

    public void setCircularDependencyBean(CircularDependencyBean circularDependencyBean) {
        this.circularDependencyBean = circularDependencyBean;
    }
}
