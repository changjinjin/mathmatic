package com.merce.woven.behavior.strategy;

import java.math.BigDecimal;

/**
 * 测试策略模式
 *
 * @author ZhengNC
 * @date 2020/8/14 8:54
 */
public class TestStrategy {

    public static void main(String[] args) {
        //测试不使用策略模式
        NoStrategyPattern payTool = new NoStrategyPattern();
        payTool.pay(new BigDecimal("10.5"), "alipay");
        payTool.pay(new BigDecimal("5.3"), "jdpay");

        //测试使用策略模式
        PayContext payContext = new PayContext(new AliPay());
        payContext.pay(new BigDecimal("8.8"));
        payContext = new PayContext(new WeiXinPay());
        payContext.pay(new BigDecimal("6.6"));
    }
}
