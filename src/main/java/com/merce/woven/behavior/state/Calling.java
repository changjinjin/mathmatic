package com.merce.woven.behavior.state;

/**
 * 状态：通话中
 *
 * @author ZhengNC
 * @date 2020/9/22 15:54
 */
public class Calling extends PhoneState {

    public Calling(Phone phone) {
        super(phone);
        stateName = "通话中";
    }

    @Override
    public void call() {
        System.out.println("正在通话中，不能发起新的通话。。。");
    }

    @Override
    public void bye() {
        phone.setState(phone.getStandby());
    }

    @Override
    public void shutdown() {
        System.out.println("通话中，正在强制关机。。。");
        phone.setState(phone.getShutdown());
    }

    @Override
    public void bootUp() {
        System.out.println("手机已经开机了，无需重复开机。");
    }
}

