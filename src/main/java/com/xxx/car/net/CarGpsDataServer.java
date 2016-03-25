package com.xxx.car.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xxx.car.service.CarHistoryRecordService;

@Service
public class CarGpsDataServer {

	@Value("${car.server.port:11000}")
	private int port = 11000;

	@Autowired
	private CarHistoryRecordService carHistoryRecordService;
	
	final EventLoopGroup bossGroup = new NioEventLoopGroup();
	final EventLoopGroup workerGroup = new NioEventLoopGroup();
	EventExecutorGroup businessLogicEventExecutorGroup = new DefaultEventExecutorGroup(4,new DefaultThreadFactory("businessLogic"));

	@PostConstruct
	public void run() throws Exception {
        // Configure the server.
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
         .channel(NioServerSocketChannel.class)
         .option(ChannelOption.SO_BACKLOG, 100)
         .childHandler(new ChannelInitializer<SocketChannel>() {
             @Override
             public void initChannel(SocketChannel ch) throws Exception {
            	 ByteBuf delimiter = Unpooled.copiedBuffer("#".getBytes());
            	 ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
            	 ch.pipeline().addLast(new StringDecoder());
            	 ch.pipeline().addLast(new StringEncoder());
                 ch.pipeline().addLast(businessLogicEventExecutorGroup,new CarGpsDataServerHandler(carHistoryRecordService));
             }
         });

        b.bind(port).sync().channel().closeFuture().addListener(new FutureListener<Object>() {
            @Override
            public void operationComplete(Future<Object> arg0) throws Exception {
              bossGroup.shutdownGracefully();
              workerGroup.shutdownGracefully();
            }
        });
    }
	
	@PreDestroy
	public void destory() {
	   bossGroup.shutdownGracefully();
	   workerGroup.shutdownGracefully();
	}

}
