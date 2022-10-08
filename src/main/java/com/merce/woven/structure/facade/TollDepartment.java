package com.merce.woven.structure.facade;

/**
 * 收费部
 *
 * @author ZhengNC
 * @date 2020/7/30 10:47
 */
public class TollDepartment implements Department {
    @Override
    public void process() {
        System.out.println("缴费完成！");
    }
}
