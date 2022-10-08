package com.merce.woven.behavior.state;

/**
 * 手机状态
 *
 * @author ZhengNC
 * @date 2020/9/22 15:20
 */
public abstract class PhoneState implements PhoneAction {

    protected Phone phone;

    protected String stateName;

    public PhoneState(Phone phone){
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "状态："+stateName;
    }
}

