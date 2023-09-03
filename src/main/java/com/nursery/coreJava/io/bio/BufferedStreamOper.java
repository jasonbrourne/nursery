package com.nursery.coreJava.io.bio;

import java.io.*;

/**
 * <StringBufferInputStream><br>
 *
 * @author jasonbrourne
 * @time 2022/3/9 12:11
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BufferedStreamOper {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[] { 127, 22 };
        BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(b));
        int bb;
        while ((bb = bis.read()) != -1) {
            System.out.println(bb);
        }
    }
}
