package com.nursery.coreJava.reflect.aop;

import java.lang.reflect.Method;

/**
 * <拦截器><br>
 *
 * @author jasonbrourne
 * @time 2022/2/24 2:37
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Aspect
public class MyAspect {
    @Pointcut("com.nursery.coreJava.reflect.aop.TestMethod.*(..)")
    public void pointCut(){
    }
    @Before("pointCut()")
    public void doBefore(Method method, Object object){
        System.out.println("doBefore");
    }
    @After("pointCut()")
    public void doAfter(Method method, Object object){
        System.out.println("doAfter");
    }
}
