package com.merce.woven.behavior.state;

/**
 * 状态：已关机
 *
 * @author ZhengNC
 * @date 2020/9/22 16:13
 */
public class Shutdown extends PhoneState {

    public Shutdown(Phone phone) {
        super(phone);
        stateName = "已关机";
    }

    @Override
    public void call() {
        System.out.println("手机已关机，无法通话！");
    }

    @Override
    public void bye() {
        System.out.println("手机已关机，不需挂断！");
    }

    @Override
    public void shutdown() {
        System.out.println("手机已关机，不需重复关机！");
    }

    @Override
    public void bootUp() {
        phone.setState(phone.getStandby());
    }
}
