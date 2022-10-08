package com.merce.woven.structure.facade;

/**
 * 测试外观模式
 *
 * @author ZhengNC
 * @date 2020/7/30 10:59
 */
public class TestFacade {
    public static void main(String[] args) {
        Receptionist receptionist = new Receptionist();
        //挂号
        receptionist.regProcess();
        //问诊
        receptionist.optProcess();
        //缴费
        receptionist.tollProcess();
        //取药
        receptionist.dispenseProcess();
    }
}
