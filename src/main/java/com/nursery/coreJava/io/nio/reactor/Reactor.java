package com.nursery.coreJava.io.nio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <Reactor><br>
 *
 * @author jasonbrourne
 * @time 2023/2/2 16:46
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Reactor implements Runnable {
    private final Selector selector;
    private final ServerSocketChannel serverSocket;

    public Reactor(int port) throws IOException {
        // 创建服务端的ServerSocketChannel
        serverSocket = ServerSocketChannel.open();
        // 设置为非阻塞模式
        serverSocket.configureBlocking(false);
        // 创建一个Selector多路复用器
        selector = Selector.open();
        SelectionKey key = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        // 绑定服务端端口
        serverSocket.bind(new InetSocketAddress(port));
        // 为服务端Channel绑定一个Acceptor
        key.attach(new Acceptor(serverSocket));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();  // 服务端使用一个线程不断等待客户端的连接到达
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    // 监听到客户端连接事件后将其分发给Acceptor
                    dispatch(iterator.next());
                    iterator.remove();
                }

                selector.selectNow();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatch(SelectionKey key) throws IOException {
        // 这里的attachement也即前面为服务端Channel绑定的Acceptor，
        // 调用其run()方法进行。客户端连接的获取，并且进行分发
        Runnable attachment = (Runnable) key.attachment();
        attachment.run();
    }
}
