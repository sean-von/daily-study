package com.smikevon.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by fengxiao on 15-1-4.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);

        //discard method
        //((ByteBuf)msg).release();

        //print the message
        *//*ByteBuf in = (ByteBuf)msg ;
        try{
            while(in.isReadable()){
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        }finally{
            ReferenceCountUtil.release(msg);
        }*//*

        //resend the message
        ctx.write(msg);
        ctx.flush();
    }*/

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        //super.channelActive(ctx);
        final ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int)(System.currentTimeMillis()/1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time);

        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                assert f == channelFuture;
                ctx.close();
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
