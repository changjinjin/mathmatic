package com.merce.woven.behavior.state;

/**
 * 状态：待机中
 *
 * @author ZhengNC
 * @date 2020/9/22 16:00
 */
public class Standby extends PhoneState {

    public Standby(Phone phone) {
        super(phone);
        stateName = "待机中";
    }

    @Override
    public void call() {
        phone.setState(phone.getCalling());
    }

    @Override
    public void bye() {
        System.out.println("不在通话状态，无需挂断！");
    }

    @Override
    public void shutdown() {
        phone.setState(phone.getShutdown());
    }

    @Override
    public void bootUp() {
        System.out.println("手机已经开机了，无需重复开机。");
    }
}

