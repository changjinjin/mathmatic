package com.merce.woven.create.singleton;

/**
 * 饿汉式单例
 */
//饿汉式单例在类加载的时候就创建好对象，因此线程安全。但程序中可能并不需要刚开始就用到该类的对象，因此类加载时就创建浪费性能和空间。
public class HungrySingleton {
    private static HungrySingleton INSTANCE = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
