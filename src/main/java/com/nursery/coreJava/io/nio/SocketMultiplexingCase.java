package com.nursery.coreJava.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <NIO3.0 多路复用><br>
 *
 * @author jasonbrourne
 * @time 2022/3/10 0:03
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 * 多路复用器 select poll epoll
 */
public class SocketMultiplexingCase {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // serverSocketChannel绑定ip端口,在操作系统的生成文件描述符,假设为fd1
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8653));
        // ServerSocket.accpet操作设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 打开多路复用器
        Selector selector = Selector.open();

        /**
         * 如果 select,poll:jvm里开辟一个数组将fd1放进去
         *      epoll ctl(fd3,ADD,fd1,EPOLLIN)
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            Set<SelectionKey> keys = selector.keys();
            System.out.println("SelectionKeys size:" + keys.size());
            while (selector.select() > 0) {
                // 返回的有状态的fd集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectionKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey selectionKey = (SelectionKey) iter.next();
                    iter.remove();// iter不remove会重复循环
                    //因为我们只注册了ACCEPT事件，所以这里只写了当连接处于这个状态时的处理程序
                    if (selectionKey.isAcceptable()) {
                        //拿到产生这个事件的通道
                        ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel clientChannel = serverChannel.accept();
                        clientChannel.configureBlocking(false);
                        //并为这个通道注册一个读事件
                        clientChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        while (clientChannel.read(byteBuffer) > 0) {
                            byteBuffer.flip();
                            System.out.printf("来自客户端的数据" + new String(byteBuffer.array()));
                            byteBuffer.clear();
                        }
                        byteBuffer.clear();
                        byteBuffer.put("客户端你好".getBytes("UTF-8"));
                        byteBuffer.flip();
                        clientChannel.write(byteBuffer);
                    }
                }
            }
        }
    }
}
