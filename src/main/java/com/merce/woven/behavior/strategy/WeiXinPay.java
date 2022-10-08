package com.merce.woven.behavior.strategy;

import java.math.BigDecimal;

/**
 * 微信支付
 *
 * @author ZhengNC
 * @date 2020/8/14 9:12
 */
public class WeiXinPay implements PayStrategy {
    @Override
    public void doPay(BigDecimal money) {
        System.out.println("通过微信支付："+money.toString()+"元");
    }
}
