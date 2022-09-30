package com.merce.woven.structure.decorator;

import java.math.BigDecimal;

/**
 * 青菜配料
 *
 * @author ZhengNC
 * @date 2020/7/2 11:01
 */
public class VegetableDecorator implements Cake {

    private Cake cake;

    private BigDecimal price;

    private String name;

    public VegetableDecorator(Cake cake) {
        this.cake = cake;
        price = new BigDecimal("0.5");
        name = "青菜";
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

