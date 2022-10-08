package com.merce.woven.behavior.observer.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试订单事件
 * @author zheng
 * @version 1.0.0
 * @date 2021/9/2 16:55
 */
@RestController
public class TestOrderController {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 测试订单事件
     * @return
     */
    @GetMapping("testOrder")
    public String testOrder(){
        OrderEvent orderEvent = new OrderEvent(this, "张三买了方便面");
        //发布事件
        applicationContext.publishEvent(orderEvent);
        return "成功";
    }
}

