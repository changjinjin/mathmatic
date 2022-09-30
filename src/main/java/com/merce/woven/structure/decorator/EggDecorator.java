package com.merce.woven.structure.decorator;

import java.math.BigDecimal;

/**
 * 鸡蛋配料
 *
 * @author ZhengNC
 * @date 2020/7/2 10:55
 */
public class EggDecorator implements Cake {

    private Cake cake;

    private BigDecimal price;

    private String name;

    public EggDecorator(Cake cake){
        this.cake = cake;
        price = new BigDecimal("1.5");
        name = "鸡蛋";
    }

    @Override
    public BigDecimal getPrice() {
        return cake.getPrice().add(this.price);
    }

    @Override
    public String getName() {
        return this.name + cake.getName();
    }
}

