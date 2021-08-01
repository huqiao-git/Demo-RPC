package com.mc.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {

    /**
     * @param service 服务
     * @param port    端口
     */
    public void publisher(Object service, int port) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //BIO(阻塞IO)
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {  //不断监听客户端连接
                //当没有客户端连接过来的时候,accept会阻塞
                Socket socket = serverSocket.accept();  //等待客户端的连接
                //↑建立通信
                //↓基于通信进行数据传输
                //TODO 一个Socket对象代表一个客户端连接 服务端的吞吐量非常低
                //socket.getInputStream();  //IO阻塞 此时如果客户端没有数据传输过来过来
                //TODO 利用多线程提高了服务端的并行处理数
                executorService.execute(new ProcessHandlerThread(service, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
