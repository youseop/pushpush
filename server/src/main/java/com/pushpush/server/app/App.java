package com.pushpush.server.app;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;

public class App {
    private static final String HOST = "0.0.0.0";
    private static final int PORT = 12000;  //서버 포트 번호
    private static final int READ_TIME_OUT = 60;  //읽기 타임아웃 설정(클라 -> 서버)
    private static final int WRITE_TIME_OUT = 30; //쓰기 타임아웃 설정(서버 -> 클라)

    public static void main( String[] args ) {
        App app = new App();
        MyServerHandler handler = app.makeCallbackToDo();
        app.init(handler);
    }

    public MyServerHandler makeCallbackToDo(){
        return new MyServerHandler(new MyCallBack() {
            public void read(String read) {    //요청에 따른 처리
                System.out.println("요청들어온 메시지 입니다 : "+ read);
            }
            public String write(String msg) {   //응답할 내용
                String result = "~~보낼메시지 입니다.~~\n";
                return result;
            }
            public void afterClose(ChannelHandlerContext ctx) {  //커넥션 끊기면 할 내용
                System.out.println("커넥션이 끊기면 동작하는 메소드 입니다.");
            }
        });
    }

    public void init(final MyServerHandler handler){
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.localAddress(new InetSocketAddress(HOST, PORT));
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast("ReadTimeoutHandler", new ReadTimeoutHandler(READ_TIME_OUT));
                    socketChannel.pipeline().addLast("WriteTimeoutHandler", new WriteTimeoutHandler(WRITE_TIME_OUT));
                    socketChannel.pipeline().addLast("myHandler", handler);
                }
            })
                    .option(ChannelOption.SO_BACKLOG, 128)  //동시 접속 수
                    .childOption(ChannelOption.SO_KEEPALIVE, true);  //패킷여부
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try { group.shutdownGracefully().sync(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

}