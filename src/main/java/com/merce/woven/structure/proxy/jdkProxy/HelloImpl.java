package com.merce.woven.structure.proxy.jdkProxy;

/**
 * @author ZhengNC
 * @date 2020/7/1 10:12
 */
public class HelloImpl implements Hello {
    @Override
    public String hello(String name) {
        System.out.println("执行 hello 方法。。。");
        return "hello " + name;
    }
}
