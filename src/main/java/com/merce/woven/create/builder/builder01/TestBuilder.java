package com.merce.woven.create.builder.builder01;

/**
 * 建造者模式
 */
//建造者模属于设计模式中的创建型模式。建造者模式提供了一种最佳的创建对象的方式。
//建造者模式将一个复杂的对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示。

//建造过程：客户端直接和Director（指挥者）沟通；
//通过向Director传入不同的ConcreteBuilder（具体建造者）构建不同表示的Product（产品）。
public class TestBuilder {
    public static void main(String[] args) {
        //建造品牌电脑

        //建造联想电脑
        Computer lenovoComputer = ComputerDirector.constructComputer(new LenovoComputerBuilder());
        System.out.println(lenovoComputer);
        //建造戴尔电脑
        Computer dellComputer = ComputerDirector.constructComputer(new DellComputerBuilder());
        System.out.println(dellComputer);
    }
}
