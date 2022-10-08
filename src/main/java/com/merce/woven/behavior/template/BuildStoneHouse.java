package com.merce.woven.behavior.template;

/**
 * 建造石屋
 *
 * @author ZhengNC
 * @date 2020/8/18 20:18
 */
public class BuildStoneHouse extends BuildHouse {

    @Override
    public void buildGround() {
        System.out.println("铺石板");
    }

    @Override
    public void buildWall() {
        System.out.println("垒石墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("用石板封顶");
    }
}

