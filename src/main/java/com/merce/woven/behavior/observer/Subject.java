package com.merce.woven.behavior.observer;

/**
 * 主题（发布者，被观察者）
 *
 * @author ZhengNC
 * @date 2020/6/29 22:35
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObserver();
}

