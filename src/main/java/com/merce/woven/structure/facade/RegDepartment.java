package com.merce.woven.structure.facade;

/**
 * 挂号部
 *
 * @author ZhengNC
 * @date 2020/7/30 10:42
 */
public class RegDepartment implements Department {
    @Override
    public void process() {
        System.out.println("挂号完成！");
    }
}
