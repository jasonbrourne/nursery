package com.nursery.coreJava.reflect.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * <main方法类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/23 22:43
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ClassOper {

    public static void main(String[] args) {
        // 生成字节码文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\ideaProject\\nursery\\target\\classes\\com\\nursery\\coreJava\\reflect\\cglib");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Bye.class);
        enhancer.setCallback(new MyInterceptor());
        // 过滤器,返回第几个拦截器
        enhancer.setCallbackFilter((method -> {
            return 0;
        }));

        Bye bye = (Bye) enhancer.create();
        bye.sayBye();
    }
}
