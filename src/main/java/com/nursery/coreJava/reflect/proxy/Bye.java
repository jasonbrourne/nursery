package com.nursery.coreJava.reflect.proxy;

/**
 * <实现类><br>
 *
 * @author jasonbrourne
 * @time 2022/2/21 0:07
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Bye implements ByeInterface {

    @Override
    public void sayBye() {
        System.out.println("Bye 冬奥!");
    }
}
