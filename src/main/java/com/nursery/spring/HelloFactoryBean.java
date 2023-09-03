package com.nursery.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * <factoryBean使用><br>
 *
 * @author jasonbrourne
 * @time 2023/2/12 20:48
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloFactoryBean implements FactoryBean<SimpleBean> {

    @Override
    public SimpleBean getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return SimpleBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
