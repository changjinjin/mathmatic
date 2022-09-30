package com.merce.woven.structure.decorator;

import java.math.BigDecimal;

/**
 * 饼 的接口
 *
 * @author ZhengNC
 * @date 2020/7/2 10:41
 */
public interface Cake {

    BigDecimal getPrice();

    String getName();
}
