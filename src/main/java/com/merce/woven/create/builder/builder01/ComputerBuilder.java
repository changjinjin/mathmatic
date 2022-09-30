package com.merce.woven.create.builder.builder01;

/**
 * 计算机建造者接口
 *
 * @author ZhengNC
 * @date 2020/7/16 19:32
 */
public interface ComputerBuilder {

    /**
     * 建造CPU(必要)
     */
    void buildCpu();

    /**
     * 建造主板(必要)
     */
    void buildBoard();


    /**
     * 建造内存(必要)
     */
    void buildRam();

    /**
     * 建造硬盘(必要)
     */
    void buildHardDisk();

    /**
     * 建造电源(必要)
     */
    void buildPowerSupply();

    /**
     * 建造显示器
     */
    void buildMonitor();

    /**
     * 建造鼠标
     */
    void buildMouse();

    /**
     * 建造键盘
     */
    void buildKeyboard();

    /**
     * 建造计算机
     *
     * @return
     */
    Computer buildComputer();
}

