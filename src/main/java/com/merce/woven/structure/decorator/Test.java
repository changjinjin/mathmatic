package com.merce.woven.structure.decorator;

public class Test {
    public static void main(String[] args) {
        //要一个油饼，不要任何配料
        Cake cake1 = new OilCake();
        System.out.println(cake1.getName() + "\t" + cake1.getPrice() + "元");

        //要一个加鸡蛋的煎饼
        Cake cake2 = new EggDecorator(new BatterCake());
        System.out.println(cake2.getName() + "\t" + cake2.getPrice() + "元");

        //要一个加鸡蛋和海带的油饼
        Cake cake3 = new EggDecorator(new KelpDecorator(new OilCake()));
        System.out.println(cake3.getName() + "\t" + cake3.getPrice() + "元");

        //要一个加青菜和鸡蛋的煎饼
        Cake cake4 = new VegetableDecorator(new EggDecorator(new BatterCake()));
        System.out.println(cake4.getName() + "\t" + cake4.getPrice() + "元");
    }
}
