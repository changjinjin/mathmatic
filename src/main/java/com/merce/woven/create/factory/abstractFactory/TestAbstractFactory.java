package com.merce.woven.create.factory.abstractFactory;

public class TestAbstractFactory {
    public static void main(String[] args) {
        //创建奥迪工厂
        AbstractFactory factory = new AudiFactory();
        //奥迪工厂生产汽车
        Car car = factory.getCar();
        //奥迪工厂生产手机
        Phone phone = factory.getPhone();
        car.carInfo();
        phone.phoneInfo();

        //创建奔驰工厂
        AbstractFactory factory1 = new BenzFactory();
        //奔驰工厂生产汽车
        Car car1 = factory1.getCar();
        //奔驰工厂生产手机
        Phone phone1 = factory1.getPhone();
        car1.carInfo();
        phone1.phoneInfo();
    }
}

/**
 * 抽象工厂 抽象类
 *
 * @author ZhengNC
 * @date 2020/7/13 17:56
 */
abstract class AbstractFactory implements CarFactory, PhoneFactory {
}

/**
 * 奔驰产品工厂
 *
 * @author ZhengNC
 * @date 2020/7/13 17:11
 */
class BenzFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new BenzCar();
    }

    @Override
    public Phone getPhone() {
        return new BenzPhone();
    }
}

/**
 * 奥迪产品工厂
 *
 * @author ZhengNC
 * @date 2020/7/13 17:10
 */
class AudiFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new AudiCar();
    }

    @Override
    public Phone getPhone() {
        return new AudiPhone();
    }
}