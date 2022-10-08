package com.merce.woven.structure.proxy.staticProxy;

public class Test {
    public static void main(String[] args) {
        //创建被代理的对象
        Hello hello = new HelloImpl();
        //创建代理对象
        Hello helloLogProxy = new HelloLogProxy(hello);
        //执行对象的方法
        String result = helloLogProxy.hello("张三");
        //打印执行方法的返回结果
        System.out.println(result);
    }
}
