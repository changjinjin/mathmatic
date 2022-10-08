package com.merce.woven.behavior.state;

/**
 * 不使用状态模式的实现方式
 *
 * @author ZhengNC
 * @date 2020/9/22 16:48
 */
public class NotUsedStatePattern {

    enum State{
        /** 通话中 */
        Calling,
        /** 待机中 */
        Standby,
        /** 已关机 */
        Shutdown
    }

    private State state = State.Shutdown;

    /**
     * 打电话
     */
    public void call() {
        switch (state){
            case Calling:
                System.out.println("正在通话中，不能发起新的通话。。。");
                break;
            case Standby:
                state = State.Calling;
                break;
            case Shutdown:
                System.out.println("手机已关机，无法通话！");
                break;
            default:
                break;
        }
    }

    /**
     * 挂电话
     */
    public void bye() {
        switch (state){
            case Calling:
                state = State.Standby;
                break;
            case Standby:
                System.out.println("不在通话状态，无需挂断！");
                break;
            case Shutdown:
                System.out.println("手机已关机，不需挂断！");
                break;
            default:
                break;
        }
    }

    /**
     * 关机
     */
    public void shutdown() {
        switch (state){
            case Calling:
                System.out.println("通话中，正在强制关机。。。");
                state = State.Shutdown;
                break;
            case Standby:
                state = State.Shutdown;
                break;
            case Shutdown:
                System.out.println("手机已关机，不需重复关机！");
                break;
            default:
                break;
        }
    }

    /**
     * 开机
     */
    public void bootUp() {
        switch (state){
            case Calling:
                System.out.println("手机已经开机了，无需重复开机。");
                break;
            case Standby:
                System.out.println("手机已经开机了，无需重复开机。");
                break;
            case Shutdown:
                state = State.Standby;
                break;
            default:
                break;
        }
    }
}

