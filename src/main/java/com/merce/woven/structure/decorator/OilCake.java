package com.merce.woven.structure.decorator;

import java.math.BigDecimal;

/**
 * 油饼
 *
 * @author ZhengNC
 * @date 2020/7/2 10:48
 */
public class OilCake implements Cake{

    private BigDecimal price;

    private String name;

    public OilCake(){
        price = new BigDecimal("1.0");
        name = "油饼";
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
