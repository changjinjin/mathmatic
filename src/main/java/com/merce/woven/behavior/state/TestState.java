package com.merce.woven.behavior.state;

/**
 * 测试状态模式
 *
 * @author ZhengNC
 * @date 2020/9/22 16:31
 */
public class TestState {

    public static void main(String[] args) {
        Phone phone = new Phone();
        System.out.println(phone.getState());
        phone.call();
        System.out.println(phone.getState());
        phone.bye();
        System.out.println(phone.getState());
        phone.bootUp();
        System.out.println(phone.getState());
        phone.call();
        System.out.println(phone.getState());
        phone.bye();
        System.out.println(phone.getState());
        phone.shutdown();
        System.out.println(phone.getState());
    }
}
