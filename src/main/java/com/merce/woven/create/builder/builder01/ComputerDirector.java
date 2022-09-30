package com.merce.woven.create.builder.builder01;

public class ComputerDirector {
    public static Computer constructComputer(ComputerBuilder computerBuilder){
        //构造CPU
        computerBuilder.buildCpu();
        //构造主板
        computerBuilder.buildBoard();
        //构造内存
        computerBuilder.buildRam();
        //构造硬盘
        computerBuilder.buildHardDisk();
        //构造电源
        computerBuilder.buildPowerSupply();
        //构造显示器
        computerBuilder.buildMonitor();
        //构造鼠标
        computerBuilder.buildMouse();
        //构造键盘
        computerBuilder.buildKeyboard();
        //返回构造的计算机
        return computerBuilder.buildComputer();
    }
}
