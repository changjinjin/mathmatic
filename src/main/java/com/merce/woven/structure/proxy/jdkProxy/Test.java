package com.merce.woven.structure.proxy.jdkProxy;

public class Test {
    public static void main(String[] args) {
        Hello proxyHello = LogInvocation.createProxy(HelloImpl.class);
        String result = proxyHello.hello("张三");
        System.out.println(result);
    }
}
