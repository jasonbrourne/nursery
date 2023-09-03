package com.nursery.spring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <循环依赖Bean><br>
 *
 * @author jasonbrourne
 * @time 2023/2/28 21:04
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CircularDependencyBean {

    private SimpleBean simpleBean;

    @Autowired
    public CircularDependencyBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }

    public SimpleBean getSimpleBean() {
        return simpleBean;
    }

    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}
