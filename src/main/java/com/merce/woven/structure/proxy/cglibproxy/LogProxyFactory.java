package com.merce.woven.structure.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 创建对象的日志代理
 * 代理对象在执行时会打印出入参和出参信息
 *
 * @author ZhengNC
 * @date 2020/7/1 11:06
 */
public class LogProxyFactory<T> implements MethodInterceptor {

    private T target;

    public LogProxyFactory(T target){
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("入参：" + Arrays.toString(objects));

        Object result = method.invoke(target, objects);

        System.out.println("出参：" + result);

        return result;
    }

    public static<T> T createProxy(Class targetClass){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        try {
            LogProxyFactory logProxyFactory = new LogProxyFactory(targetClass.newInstance());
            enhancer.setCallback(logProxyFactory);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) enhancer.create();
    }
}
