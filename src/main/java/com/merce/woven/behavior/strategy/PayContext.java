package com.merce.woven.behavior.strategy;

import java.math.BigDecimal;

/**
 * 支付工具
 *
 * @author ZhengNC
 * @date 2020/8/14 9:14
 */
public class PayContext {

    /**
     * 支付策略
     */
    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 支付
     *
     * @param money 支付金额
     */
    public void pay(BigDecimal money){
        payStrategy.doPay(money);
    }
}
