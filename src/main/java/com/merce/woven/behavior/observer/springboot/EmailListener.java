package com.merce.woven.behavior.observer.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 订单事件监听者（发送邮件）
 * @author zheng
 * @version 1.0.0
 * @date 2021/9/2 16:47
 */
@Slf4j
@Component
public class EmailListener implements ApplicationListener<OrderEvent> {
    @Override
    @Async
    public void onApplicationEvent(OrderEvent event) {
        log.info("{} 用户下单成功！发送邮件，邮件内容为：{}", Thread.currentThread(), event.getOrderContent());
    }
}

