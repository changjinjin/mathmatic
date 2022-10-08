package com.merce.woven.behavior.observer;

/**
 * @author ZhengNC
 * @date 2020/6/29 22:55
 */
public class Test {

    public static void main(String[] args) {
        Baby baby = new Baby();
        Father father = new Father(baby);
        Mother mother = new Mother(baby);
        baby.changeMood("高兴");
        baby.changeMood("哭闹");
    }
}
