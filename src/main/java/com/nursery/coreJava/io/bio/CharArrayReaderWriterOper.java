package com.nursery.coreJava.io.bio;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * <CharArrayReader><br>
 *
 * @author jasonbrourne
 * @time 2022/3/9 13:23
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CharArrayReaderWriterOper {
    public static void main(String[] args) throws IOException {
        char[] c = new char[] { '1', '2', '3' };
        CharArrayReader car = new CharArrayReader(c);
        int i;
        while ((i = car.read()) != -1) {
            System.out.println((char)i);
        }
    }
}
