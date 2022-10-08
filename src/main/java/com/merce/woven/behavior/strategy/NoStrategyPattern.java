package com.merce.woven.behavior.strategy;

import java.math.BigDecimal;

/**
 * 不使用策略模式
 *
 * @author ZhengNC
 * @date 2020/8/14 8:53
 */
public class NoStrategyPattern {

    /**
     * 支付
     *
     * @param money 支付金额
     * @param way 支付方式
     */
    public void pay(BigDecimal money, String way){
        if ("alipay".equals(way)){
            System.out.println("通过支付宝支付："+money.toString()+"元");
        }else if ("weixinpay".equals(way)){
            System.out.println("通过微信支付："+money.toString()+"元");
        }else if ("jdpay".equals(way)){
            System.out.println("通过京东钱包支付："+money.toString()+"元");
        }else {
            System.out.println("支付失败，不支持的支付方式："+way);
        }
    }
}
