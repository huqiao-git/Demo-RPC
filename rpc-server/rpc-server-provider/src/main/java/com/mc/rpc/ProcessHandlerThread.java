package com.mc.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ProcessHandlerThread implements Runnable {

    Object service;
    Socket socket;

    public ProcessHandlerThread(Object service, Socket socket) {
        this.service = service;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
            RpcRequest request = (RpcRequest) inputStream.readObject(); //获得一个数据
            Object result = invoke(request);
            outputStream.writeObject(result);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = Class.forName(request.getClassName());
        Method method = clazz.getMethod(request.getMethodName(), request.getTypes());
        return method.invoke(service, request.getParams());
    }
}
