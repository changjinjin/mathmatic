package com.merce.woven.behavior.strategy;

import java.math.BigDecimal;

/**
 * @author ZhengNC
 * @date 2020/8/14 9:13
 */
public class JDPay implements PayStrategy {
    @Override
    public void doPay(BigDecimal money) {
        System.out.println("通过京东钱包支付："+money.toString()+"元");
    }
}
