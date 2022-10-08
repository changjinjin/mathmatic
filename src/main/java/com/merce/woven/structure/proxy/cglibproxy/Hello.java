package com.merce.woven.structure.proxy.cglibproxy;

/**
 * @author ZhengNC
 * @date 2020/7/1 11:04
 */
public class Hello {
    public String hello(String name) {
        System.out.println("执行 hello 方法。。。");
        return "hello " + name;
    }
}
