package com.mc.rpc;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        //1.动态代理
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        IHelloService helloService = rpcClientProxy.clientProxy(IHelloService.class, "localhost", 8080);
        String str = helloService.hello("huqiao");
        System.out.println(str);
    }

}
