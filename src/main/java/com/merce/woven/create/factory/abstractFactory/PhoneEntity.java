package com.merce.woven.create.factory.abstractFactory;

public class PhoneEntity {
}

/**
 * 手机接口
 *
 * @author ZhengNC
 * @date 2020/7/13 17:34
 */
interface Phone {
    /**
     * 打印手机信息
     */
    void phoneInfo();
}

class AudiPhone implements Phone{
    @Override
    public void phoneInfo() {
        System.out.println("奥迪牌手机");
    }
}

class BenzPhone implements Phone {
    @Override
    public void phoneInfo() {
        System.out.println("奔驰牌手机");
    }
}