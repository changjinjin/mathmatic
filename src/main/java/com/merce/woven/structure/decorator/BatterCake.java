package com.merce.woven.structure.decorator;

import java.math.BigDecimal;

/**
 * 煎饼
 */
public class BatterCake implements Cake{
    private BigDecimal price;

    private String name;

    public BatterCake() {
        price = new BigDecimal("2.0");
        name = "煎饼";
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
