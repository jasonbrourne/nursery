package com.nursery.coreJava.ref;

import java.io.IOException;

/**
 * <强引用><br>
 *
 * @author jasonbrourne
 * @time 2022/2/20 16:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NormalReferenceOper {

    public static void main(String[] args) throws IOException {
        T t = new T();
        t = null;
        System.gc();
    }
}

class T {
    @Override
    public void finalize() {
        System.out.println("finalize");
    }
}


