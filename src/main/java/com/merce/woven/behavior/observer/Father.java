package com.merce.woven.behavior.observer;

/**
 * 爸爸
 *
 * @author ZhengNC
 * @date 2020/6/29 22:32
 */
public class Father implements Observer{

    private Baby baby;

    public Father(Baby baby) {
        this.baby = baby;
        baby.registerObserver(this);
    }

    /**
     * 说话
     */
    public void talk(){
        System.out.println("爸爸知道了宝宝的心情：" + baby.getMood());
        System.out.println("爸爸说：宝宝心情变成" + baby.getMood());
    }

    @Override
    public void update() {
        talk();
    }
}
