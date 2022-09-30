package com.merce.woven.create.singleton;

/**
 * 懒汉式单例（双重校验锁方式，小几率不安全）
 */
public class LazySingleton2 {
    private static LazySingleton2 INSTANCE;
    private LazySingleton2(){}
    public static LazySingleton2 getInstance(){
        if(INSTANCE == null){
            synchronized (LazySingleton2.class){
                if(INSTANCE == null){
                    INSTANCE = new LazySingleton2();
                }
            }
        }
        return INSTANCE;
    }
}
