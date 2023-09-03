package com.nursery.coreJava.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <1><br>
 *
 * @author jasonbrourne
 * @time 2022/3/10 21:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MyInbound extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg);
        ctx.write(msg);
    }

    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;
        int size = buf.writerIndex();
        byte[] data = new byte[size];
        buf.getBytes(0, data);
        String dd = new String(data);

        String[] strs = dd.split("\n");
        for (String str : strs) {
            System.out.println("触发的命令: " + str + "...");
        }
        ctx.write(msg);
    }*/

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
