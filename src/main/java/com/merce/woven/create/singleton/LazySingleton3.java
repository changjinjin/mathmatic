package com.merce.woven.create.singleton;

/**
 * 懒汉式单例（双重校验锁，安全）推荐
 */
//此方式在上一种方式的基础上加上了volatile关键字，此关键字使用内存屏障禁止了指令重排序。
public class LazySingleton3 {
    private static volatile LazySingleton3 INSTANCE;
    private LazySingleton3(){}
    public static LazySingleton3 getInstance(){
        if(INSTANCE == null){
            synchronized (LazySingleton3.class){
                if(INSTANCE == null){
                    INSTANCE = new LazySingleton3();
                }
            }
        }
        return INSTANCE;
    }
}
