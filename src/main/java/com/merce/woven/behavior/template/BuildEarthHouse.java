package com.merce.woven.behavior.template;

/**
 * 建造土屋
 *
 * @author ZhengNC
 * @date 2020/8/18 20:08
 */
public class BuildEarthHouse extends BuildHouse {

    @Override
    public void buildGround() {
        System.out.println("将土地压实");
    }

    @Override
    public void buildWall() {
        System.out.println("砌土墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("用茅草封顶");
    }
}
