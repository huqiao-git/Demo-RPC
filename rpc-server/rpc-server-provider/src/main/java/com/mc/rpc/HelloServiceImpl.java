package com.mc.rpc;

public class HelloServiceImpl implements IHelloService{

    @Override
    public String hello(String str) {
        return "This is MC RPC hello method result : [" + str + "]";
    }

}
