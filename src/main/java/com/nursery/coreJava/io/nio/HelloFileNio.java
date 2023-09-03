package com.nursery.coreJava.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * <Nio读取文件Demo><br>
 *
 * @author jasonbrourne
 * @time 2023/2/1 17:46
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloFileNio {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(
                "./src\\main\\java\\com\\nursery\\coreJava\\io\\nio/a.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        while((fileChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()) {
                System.out.print((char)byteBuffer.get());
            }
            byteBuffer.clear();
        }
        file.close();
    }
}
