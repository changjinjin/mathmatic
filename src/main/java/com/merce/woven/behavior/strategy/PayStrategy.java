package com.merce.woven.behavior.strategy;

import java.math.BigDecimal;

/**
 * 支付策略接口
 *
 * @author ZhengNC
 * @date 2020/8/14 9:07
 */
public interface PayStrategy {
    /**
     * 支付
     *
     * @param money 支付金额
     */
    void doPay(BigDecimal money);
}
