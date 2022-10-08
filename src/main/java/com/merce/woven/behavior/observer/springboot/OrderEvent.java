package com.merce.woven.behavior.observer.springboot;

import org.springframework.context.ApplicationEvent;

/**
 * 订单事件
 * @author zheng
 * @version 1.0.0
 * @date 2021/9/2 16:25
 */
public class OrderEvent extends ApplicationEvent {

    /**
     * 事件内容
     */
    private String orderContent;

    /**
     * 创建订单事件
     * @param source 最初的创建者
     * @param orderContent 事件内容
     */
    public OrderEvent(Object source, String orderContent) {
        super(source);
        this.orderContent = orderContent;
    }

    public String getOrderContent() {
        return orderContent;
    }
}
