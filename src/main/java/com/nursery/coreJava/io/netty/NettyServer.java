package com.nursery.coreJava.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * <server><br>
 *
 * @author jasonbrourne
 * @time 2022/3/10 21:32
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup(2);
        NioEventLoopGroup worker = new NioEventLoopGroup(2);

        ServerBootstrap boot = new ServerBootstrap();

        try {
            boot.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel channel) throws Exception {
                            System.out.println("client...conn..." + channel);
                            ChannelPipeline p = channel.pipeline();
                            p.addLast(new MyInbound());
                        }
                    });
            ChannelFuture future = boot.bind(9090).sync();
        } catch (Exception e) {

        }
    }
}
