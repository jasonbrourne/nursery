package com.nursery.coreJava.reflect.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <main方法类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/23 22:43
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InterfaceOper {

    public static void main(String[] args) {
        // 生成字节码文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\ideaProject\\nursery\\target\\classes\\com\\nursery\\coreJava\\reflect\\cglib");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ByeInterface.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        });
        ByeInterface bye = (ByeInterface) enhancer.create();
        bye.sayBye();
    }
}
