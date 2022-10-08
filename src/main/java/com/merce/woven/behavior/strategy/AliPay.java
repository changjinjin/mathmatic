package com.merce.woven.behavior.strategy;

import java.math.BigDecimal;

/**
 * 支付宝
 *
 * @author ZhengNC
 * @date 2020/8/14 9:11
 */
public class AliPay implements PayStrategy {
    @Override
    public void doPay(BigDecimal money) {
        System.out.println("通过支付宝支付："+money.toString()+"元");
    }
}

