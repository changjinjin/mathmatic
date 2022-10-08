package com.merce.woven.structure.facade;

/**
 * 配药部
 *
 * @author ZhengNC
 * @date 2020/7/30 10:49
 */
public class DispenseDepartment implements Department {
    @Override
    public void process() {
        System.out.println("取药完成！");
    }
}
