package com.merce.woven.structure.proxy.staticProxy;

/**
 * Hello 的日志代理
 *
 * @author ZhengNC
 * @date 2020/7/1 10:14
 */
public class HelloLogProxy implements Hello {

    private Hello target;

    public HelloLogProxy(Hello target){
        this.target = target;
    }

    @Override
    public String hello(String name) {
        System.out.println("入参："+name);
        String result = target.hello(name);
        System.out.println("出参："+result);
        return result;
    }
}

