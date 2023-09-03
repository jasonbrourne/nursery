package com.nursery.coreJava.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * <NIO2.0><br>
 *
 * @author jasonbrourne
 * @time 2022/3/10 0:03
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 * nio 存在问题：可能只有2个客户端往服务端发请求,但是每次都要循环遍历一边所有的socket试图去read一遍，
 *              还有每次都要去accept一遍
 */
public class HelloSocketNio2 {

    public static void main(String[] args) throws IOException {
        List<SocketChannel> socketChannelList = new ArrayList<>();

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8653));
        // 设置ServerSocketChannel accept非阻塞
        ssc.configureBlocking(false);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000L);
                    SocketChannel sc = ssc.accept();
                    if (sc == null) {
                        System.out.println("ServerSocketChannel accept null");
                    } else {
                        System.out.println("ServerSocketChannel accept one");
                        // 设置SocketChannel read非阻塞
                        sc.configureBlocking(false);
                        socketChannelList.add(sc);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel sc : socketChannelList) {
                try {
                    while ((sc.read(buffer) != -1)) {
                        buffer.flip();
                        byte[] byteArr = new byte[buffer.limit()];
                        buffer.get(byteArr);
                        System.out.println(sc.getRemoteAddress() + new String(byteArr));
                        buffer.clear();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
