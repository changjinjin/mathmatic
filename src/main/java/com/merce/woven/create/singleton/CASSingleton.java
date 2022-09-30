package com.merce.woven.create.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS实现线程安全的懒汉式单例（线程安全）
 */
//此种方式可以保证最后提供给外界的一定是同一个单例对象，但是有可能会创建多个对象，就是说构造方法有可能会被执行多次。
public class CASSingleton {
    private CASSingleton(){}
    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();
    public static CASSingleton getInstance(){
        while (true) {
            CASSingleton singleton = INSTANCE.get();
            if(singleton != null){
                return singleton;
            }
            singleton = new CASSingleton();
            //使用CAS方式：如果值为空，就将新建的对象设置进去
            if(INSTANCE.compareAndSet(null, singleton)){
                return singleton;
            }
        }
    }
}
