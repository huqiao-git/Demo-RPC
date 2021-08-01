package com.mc.rpc;

import java.lang.reflect.Proxy;

public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> interfaceCls, String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
