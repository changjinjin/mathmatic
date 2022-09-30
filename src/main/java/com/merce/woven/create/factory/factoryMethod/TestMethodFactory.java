package com.merce.woven.create.factory.factoryMethod;

/**
 * 测试工厂方法模式
 */
public class TestMethodFactory {
    public static void main(String[] args) {
        //奥迪工厂
        CarFactory carFactory = new AudiCarFactory();
        //生产奥迪汽车
        Car car = carFactory.getCar();
        car.carInfo();

        //奔驰工厂
        CarFactory carFactory1 = new BenzCarFactory();
        //生产奔驰汽车
        Car car1 = carFactory1.getCar();
        car1.carInfo();

        //宝马工厂
        CarFactory carFactory2 = new BMWCarFactory();
        //生产宝马汽车
        Car car2 = carFactory2.getCar();
        car2.carInfo();
    }
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

/**
 * 工厂接口
 *
 * @author ZhengNC
 * @date 2020/7/13 16:33
 */
interface CarFactory {
    Car getCar();
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

class BMWCar implements Car {
    @Override
    public void carInfo() {
        System.out.println("宝马汽车");
    }
}

class BenzCarFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new BenzCar();
    }
}

class BMWCarFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new BMWCar();
    }
}

class AudiCarFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new AudiCar();
    }
}
