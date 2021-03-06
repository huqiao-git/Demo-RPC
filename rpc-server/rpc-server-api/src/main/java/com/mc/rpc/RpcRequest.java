package com.mc.rpc;

import java.io.Serializable;

public class RpcRequest implements Serializable {
    private static final long serialVersionUID = 2279159600105344533L;

    private String className;
    private String methodName;
    private Object[] params;
    private Class<?>[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
