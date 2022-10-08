package com.merce.woven.behavior.template;

/**
 * 测试模板模式
 *
 * @author ZhengNC
 * @date 2020/8/18 20:21
 */
public class TestTemplate {

    public static void main(String[] args) {
        System.out.println("---建石头房子---");
        BuildHouse buildStoneHorse = new BuildStoneHouse();
        buildStoneHorse.build();

        System.out.println("---建土房子---");
        BuildHouse buildEarthHouse = new BuildEarthHouse();
        buildEarthHouse.build();
    }
}

