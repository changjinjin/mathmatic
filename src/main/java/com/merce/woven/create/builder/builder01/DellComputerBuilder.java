package com.merce.woven.create.builder.builder01;

/**
 * 戴尔电脑建造者
 *
 * @author ZhengNC
 * @date 2020/7/21 8:36
 */
public class DellComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public DellComputerBuilder(){
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("戴尔 CPU");
    }

    @Override
    public void buildBoard() {
        computer.setBoard("戴尔主板");
    }

    @Override
    public void buildRam() {
        computer.setRam("戴尔内存");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("戴尔硬盘");
    }

    @Override
    public void buildPowerSupply() {
        computer.setPowerSupply("戴尔电源");
    }

    @Override
    public void buildMonitor() {
        computer.setMonitor("戴尔显示器");
    }

    @Override
    public void buildMouse() {
        computer.setMouse("戴尔鼠标");
    }

    @Override
    public void buildKeyboard() {
        computer.setKeyboard("戴尔键盘");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}

