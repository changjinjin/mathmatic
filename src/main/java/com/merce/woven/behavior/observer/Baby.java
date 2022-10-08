package com.merce.woven.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 小宝宝
 *
 * @author ZhengNC
 * @date 2020/6/29 22:27
 */
public class Baby implements Subject {

    private String mood;

    /**
     * 观察者列表
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * 宝宝的心情改变
     *
     * @param mood
     */
    public void changeMood(String mood){
        this.mood = mood;
        notifyObserver();
    }

    public String getMood(){
        return mood;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers){
            if (observer != null){
                observer.update();
            }
        }
    }
}

