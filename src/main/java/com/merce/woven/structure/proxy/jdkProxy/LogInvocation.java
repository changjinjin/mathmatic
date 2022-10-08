package com.merce.woven.structure.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 创建对象的日志代理
 * 代理对象在执行时会打印出入参和出参信息
 *
 * @author ZhengNC
 * @date 2020/7/1 10:26
 */
public class LogInvocation<T> implements InvocationHandler {

    /**
     * 被代理对象
     */
    private T target;

    public LogInvocation (T target){
        this.target = target;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 方法
     * @param args 参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("入参：" + Arrays.toString(args));

        Object result = method.invoke(target, args);

        System.out.println("出参：" + result);

        return result;
    }

    /**
     * 根据目标对象类型创建代理对象
     * @param implClass
     * @param <T>
     * @return 代理对象
     */
    public static<T> T createProxy(Class implClass){
        LogInvocation logInvocation = null;
        try {
            logInvocation = new LogInvocation(implClass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        T proxyObj = (T) Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), logInvocation);
        return proxyObj;
    }
}
