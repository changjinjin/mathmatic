package com.merce.woven.create.singleton;

/**
 * 懒汉式单例（线程安全，但效率低）
 */
//上一种懒汉式单例的实现方式是非线程安全的，当多个线程同时获取该对象时，可能会出现多个该对象的实例。要想实现线程安全最简单的方式就是加锁。
public class LazySingleton1 {
    private static LazySingleton1 INSTANCE;
    private LazySingleton1(){}
    public synchronized static LazySingleton1 getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazySingleton1();
        }
        return INSTANCE;
    }
}
