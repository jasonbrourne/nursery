package com.nursery.coreJava.io.bio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <ByteStreamOper><br>
 *
 * @author jasonbrourne
 * @time 2022/3/8 18:21
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ByteArrayStreamOper {
    public static void main(String[] args) {
        byte[] byteArr = new byte[] { 1, 5, 6, 8, 6, 1, 7, 3, 6, 5, 6, 4 };
        ByteArrayInputStream is = new ByteArrayInputStream(byteArr);
        int i;
        while ((i = is.read()) != -1) {
            System.out.println(i);
        }
    }
}
