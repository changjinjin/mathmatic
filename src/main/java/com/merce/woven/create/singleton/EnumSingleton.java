package com.merce.woven.create.singleton;

/**
 * 枚举方式单例（线程安全，序列化安全）推荐
 */
//枚举既保证了线程安全，又保证了序列化安全，但其实枚举类似于饿汉式，它不是懒加载的。
public enum EnumSingleton {
    INSTANCE;

    //业务方法
    public void anyMethod(){
        //do something
    }
}
