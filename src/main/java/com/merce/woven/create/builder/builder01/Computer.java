package com.merce.woven.create.builder.builder01;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 计算机
 *
 * @author ZhengNC
 * @date 2020/7/16 18:32
 */
@Getter
@Setter
@ToString
public class Computer {

    /**
     * cpu(必要)
     */
    private String cpu;

    /**
     * 主板(必要)
     */
    private String board;

    /**
     * 内存(必要)
     */
    private String ram;

    /**
     * 硬盘(必要)
     */
    private String hardDisk;

    /**
     * 电源(必要)
     */
    private String powerSupply;

    /**
     * 显示器
     */
    private String monitor;

    /**
     * 鼠标
     */
    private String mouse;

    /**
     * 键盘
     */
    private String keyboard;
}
