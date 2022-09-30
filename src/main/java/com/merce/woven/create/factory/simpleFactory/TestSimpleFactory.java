package com.merce.woven.create.factory.simpleFactory;

/**
 * 测试简单工厂
 */
//简单工厂模式真的很简单，就是对对象创建做了一层简单的封装，根据不同的参数创建不同的对象。
public class TestSimpleFactory {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("audi");
        car1.carInfo();
        Car car2 = CarFactory.getCar("benz");
        car2.carInfo();
        Car car3 = CarFactory.getCar("BMW");
        car3.carInfo();
    }
}

/**
 * 简单汽车共产
 * @author ZhengNC
 * @date 2020/7/13 16:33
 */
class CarFactory {
    public static Car getCar(String type){
        Car car = null;
        switch (type){
            case "audi":
                car = new AudiCar();
                break;
            case "benz":
                car = new BenzCar();
                break;
            case "BMW":
                car = new BMWCar();
                break;
            default:
                System.out.println("没有此类型的汽车");
                break;
        }
        return car;
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


