package com.merce.woven.create.factory.abstractFactory;

public class CarEntity {
}

/**
 * 汽车接口
 * @author ZhengNC
 * @date 2020/7/13 16:32
 */
interface Car {
    /**
     * 打印汽车的信息
     */
    void carInfo();
}

class AudiCar implements Car {
    @Override
    public void carInfo() {
        System.out.println("奥迪汽车");
    }
}

class BenzCar implements Car {
    @Override
    public void carInfo() {
        System.out.println("奔驰汽车");
    }
}