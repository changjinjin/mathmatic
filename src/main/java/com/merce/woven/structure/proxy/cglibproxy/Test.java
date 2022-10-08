package com.merce.woven.structure.proxy.cglibproxy;

/**
 * @author ZhengNC
 * @date 2020/7/1 11:13
 */
public class Test {
    public static void main(String[] args) {
        //创建代理对象
        Hello helloProxy = LogProxyFactory.createProxy(Hello.class);
        //执行对象的方法
        String result = helloProxy.hello("张三");
        //打印结果
        System.out.println(result);
    }
}

