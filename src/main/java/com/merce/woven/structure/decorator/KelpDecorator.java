package com.merce.woven.structure.decorator;

import java.math.BigDecimal;

/**
 * 海带配料
 *
 * @author ZhengNC
 * @date 2020/7/2 11:05
 */
public class KelpDecorator implements Cake {

    private Cake cake;

    private BigDecimal price;

    private String name;

    public KelpDecorator(Cake cake) {
        this.cake = cake;
        price = new BigDecimal("1.0");
        name = "海带";
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

