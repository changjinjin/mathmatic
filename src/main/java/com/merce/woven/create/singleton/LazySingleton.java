package com.merce.woven.create.singleton;

/**
 * 懒汉式单例（非线程安全）
 */
//懒汉式单例在获取兑现时提供了延迟加载的方式，可以在获取该对象时再创建该对象。
public class LazySingleton {
    private static LazySingleton INSTANCE;
    private LazySingleton(){}
    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
