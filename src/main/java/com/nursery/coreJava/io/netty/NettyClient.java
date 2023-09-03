package com.nursery.coreJava.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * <netty><br>
 *
 * @author jasonbrourne
 * @time 2022/3/10 21:18
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NettyClient {
    public static void main(String[] args) {
        try {
            NioEventLoopGroup worker = new NioEventLoopGroup();
            Bootstrap boot = new Bootstrap();
            boot.group(worker).channel(NioSocketChannel.class)
                    .remoteAddress("localhost", 9090)
                    .handler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            System.out.println("初始化");
                            ChannelPipeline p = channel.pipeline();
                            p.addLast(new MyInbound());
                        }
                    });
            ChannelFuture conn = boot.connect().sync();
            Channel client = conn.channel();
            System.out.println(client);

            ByteBuf byteBuf = Unpooled.copiedBuffer("hello world".getBytes());
            client.writeAndFlush(byteBuf).sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
