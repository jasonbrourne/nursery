package com.nursery.coreJava.reflect.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <代理类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/23 22:41
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return obj;
    }
}
