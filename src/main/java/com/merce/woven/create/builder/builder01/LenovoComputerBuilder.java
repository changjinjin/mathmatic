package com.merce.woven.create.builder.builder01;

/**
 * 联想电脑建造者
 *
 * @author ZhengNC
 * @date 2020/7/16 19:42
 */
public class LenovoComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public LenovoComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("联想定制CPU");
    }

    @Override
    public void buildBoard() {
        computer.setBoard("联想定制主板");
    }

    @Override
    public void buildRam() {
        computer.setRam("联想定制内存条");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("联想定制硬盘");
    }

    @Override
    public void buildPowerSupply() {
        computer.setPowerSupply("联想定制电源");
    }

    @Override
    public void buildMonitor() {
        computer.setMonitor("联想显示器");
    }

    @Override
    public void buildMouse() {
        computer.setMouse("联想鼠标");
    }

    @Override
    public void buildKeyboard() {
        computer.setKeyboard("联想键盘");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
