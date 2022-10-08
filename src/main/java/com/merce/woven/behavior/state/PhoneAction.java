package com.merce.woven.behavior.state;

/**
 * 电话动作
 *
 * @author ZhengNC
 * @date 2020/9/22 15:36
 */
public interface PhoneAction {

    /**
     * 通话
     */
    void call();

    /**
     * 挂掉电话
     */
    void bye();

    /**
     * 关机
     */
    void shutdown();

    /**
     * 开机
     */
    void bootUp();
}
