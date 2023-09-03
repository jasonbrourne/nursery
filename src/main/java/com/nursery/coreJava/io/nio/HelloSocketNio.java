package com.nursery.coreJava.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <SocketNio Demo><br>
 * 非阻塞ServerSocketChannel.accpet()方法和非阻塞的SocketChannel.read()方法可以
 * 可以使线程循环执行，不会阻塞在一点上面
 * 存在问题：线程一直循环浪费CPU资源
 *
 * @author jasonbrourne
 * @time 2023/2/2 10:52
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HelloSocketNio {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8653));
        // 设置ServerSocketChannel accept非阻塞
        ssc.configureBlocking(false);
        while (true) {
            Thread.sleep(2000L);
            SocketChannel sc = ssc.accept();
            if(sc == null) {
                System.out.println("ServerSocketChannel accept null");
            } else {
                System.out.println("ServerSocketChannel accept one");
                // 设置SocketChannel read非阻塞
                sc.configureBlocking(false);
                readBuffer(sc);
            }
        }
    }

    private static void readBuffer(SocketChannel sc) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
        while((sc.read(buffer) != -1)) {
            buffer.flip();
            byte[] byteArr = new byte[buffer.limit()];
            buffer.get(byteArr);
            System.out.println(sc.getRemoteAddress() + new String(byteArr));
            buffer.clear();
        }
    }
}
