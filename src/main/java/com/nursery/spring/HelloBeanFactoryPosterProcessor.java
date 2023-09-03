package com.nursery.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * <HelloBeanFactoryPosterProcessor><br>
 *
 * @author jasonbrourne
 * @time 2022/3/13 17:41
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloBeanFactoryPosterProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("simpleBean");
        beanDefinition.getPropertyValues().add("name", "shaD");
    }
}
