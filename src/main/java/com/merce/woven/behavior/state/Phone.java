package com.merce.woven.behavior.state;

public class Phone implements PhoneAction{

    /**
     * 状态：通话中
     */
    private final PhoneState Calling = new Calling(this);
    /**
     * 状态：待机中
     */
    private final PhoneState standby = new Standby(this);
    /**
     * 状态：已关机
     */
    private final PhoneState shutdown = new Shutdown(this);

    /**
     * 当前状态
     */
    private PhoneState state = shutdown;

    public PhoneState getCalling() {
        return Calling;
    }

    public PhoneState getStandby() {
        return standby;
    }

    public PhoneState getShutdown() {
        return shutdown;
    }

    public PhoneState getState() {
        return state;
    }

    public void setState(PhoneState state) {
        this.state = state;
    }

    @Override
    public void call() {
        state.call();
    }

    @Override
    public void bye() {
        state.bye();
    }

    @Override
    public void shutdown() {
        state.shutdown();
    }

    @Override
    public void bootUp() {
        state.bootUp();
    }
}
