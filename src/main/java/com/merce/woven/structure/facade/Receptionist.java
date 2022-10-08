package com.merce.woven.structure.facade;

/**
 * 接待员
 *
 * @author ZhengNC
 * @date 2020/7/30 10:52
 */
public class Receptionist {
    /**
     * 挂号部对象
     */
    private RegDepartment regDepartment;

    /**
     * 门诊部对象
     */
    private OptDepartment optDepartment;

    /**
     * 收费部对象
     */
    private TollDepartment tollDepartment;

    /**
     * 配药部对象
     */
    private DispenseDepartment dispenseDepartment;

    public Receptionist(){
        regDepartment = new RegDepartment();
        optDepartment = new OptDepartment();
        tollDepartment = new TollDepartment();
        dispenseDepartment = new DispenseDepartment();
    }

    /**
     * 挂号
     */
    public void regProcess(){
        regDepartment.process();
    }

    /**
     * 问诊
     */
    public void optProcess(){
        optDepartment.process();
    }

    /**
     * 缴费
     */
    public void tollProcess(){
        tollDepartment.process();
    }

    /**
     * 取药
     */
    public void dispenseProcess(){
        dispenseDepartment.process();
    }
}
