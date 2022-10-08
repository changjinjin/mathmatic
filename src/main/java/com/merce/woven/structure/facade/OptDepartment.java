package com.merce.woven.structure.facade;

/**
 * 门诊部
 *
 * @author ZhengNC
 * @date 2020/7/30 10:45
 */
public class OptDepartment implements Department {
    @Override
    public void process() {
        System.out.println("问诊完成！");
    }
}
