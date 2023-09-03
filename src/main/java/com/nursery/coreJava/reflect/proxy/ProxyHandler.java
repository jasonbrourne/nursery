package com.nursery.coreJava.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <代理类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/21 0:05
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ProxyHandler implements InvocationHandler {

    private Object o;

    public ProxyHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before proxy");
        method.invoke(o, args);
        System.out.println("after proxy");
        return null;
    }
}
