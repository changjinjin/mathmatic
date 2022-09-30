package com.merce.woven.create.factory.abstractFactory;

public class FactoryEntity {
}

/**
 * 手机工厂接口
 *
 * @author ZhengNC
 * @date 2020/7/13 17:52
 */
interface PhoneFactory {
    Phone getPhone();
}

/**
 * 汽车工厂接口
 *
 * @author ZhengNC
 * @date 2020/7/13 16:33
 */
interface CarFactory {
    Car getCar();
}
