package com.merce.woven.behavior.template;

/**
 * 建造房屋模板
 *
 * @author ZhengNC
 * @date 2020/8/18 19:52
 */
public abstract class BuildHouse {

    /**
     * 打地基
     */
    public abstract void buildGround();

    /**
     * 砌墙
     */
    public abstract void buildWall();

    /**
     * 封顶
     */
    public abstract void buildRoof();

    /**
     * 建造房屋
     */
    public final void build(){
        buildGround();
        buildWall();
        buildRoof();
    }
}

