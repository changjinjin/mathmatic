package com.merce.woven.create.singleton;

/**
 * 静态内部类方式的单例（线程安全）推荐
 */
//静态内部类方式实现的单例可以像懒汉式单例一样实现懒加载，其原理是当静态内部类被引用时，
//类加载器会将静态内部类加载到 JVM 中，类加载器加载 Java 类的过程本身就是线程安全的，所以间接实现了创建单例实例的线程安全。
public class InnerClassSingleton {
    private static class SingletonHolder{
        private static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
    private InnerClassSingleton(){}
    public static InnerClassSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
