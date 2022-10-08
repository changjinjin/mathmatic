package com.merce.woven.behavior.observer;

/**
 * 妈妈
 *
 * @author ZhengNC
 * @date 2020/6/29 22:33
 */
public class Mother implements Observer {

    private Baby baby;

    public Mother(Baby baby) {
        this.baby = baby;
        baby.registerObserver(this);
    }

    /**
     * 行动
     */
    public void action(){
        System.out.println("妈妈知道了宝宝的心情：" + baby.getMood());
        System.out.println("妈妈抱起了宝宝");
    }

    @Override
    public void update() {
        action();
    }
}
