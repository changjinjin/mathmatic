package com.merce.woven.create.prototype;

public class Client {
    public static void main(String[] args) {
        PrototypeCache cache = PrototypeCache.getInstance();
        //创建一些原型对象
        cache.loadCache();
        //根据原型获取一个对象
        //根据原型获取一个对象
        Prototype p1 = cache.getPrototype(1);
        System.out.println(p1);

        //修改获取的对象
        p1.setName("asd");
        p1.getObjs().add("aaa");
        System.out.println(p1);

        //再次根据同一个原型获取对象
        Prototype p1Again = cache.getPrototype(1);
        System.out.println(p1Again);
    }
}
