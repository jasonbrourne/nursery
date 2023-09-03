package com.nursery.coreJava.reflect.proxy;

import java.lang.reflect.Proxy;

/**
 * <操作类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/21 0:08
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ProxyOper {

    public static void main(String[] args) {
        // 设置变量可以保存动态代理类，默认名称以 $Proxy0 格式命名
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ByeInterface bye1 = (ByeInterface) Proxy
                .newProxyInstance(ByeInterface.class.getClassLoader(), new Class[] { ByeInterface.class },
                        new ProxyHandler(new Bye()));
        bye1.sayBye();
    }
}
