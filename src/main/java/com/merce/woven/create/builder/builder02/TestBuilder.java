package com.merce.woven.create.builder.builder02;

/**
 * 测试建造者模式
 *
 * @author ZhengNC
 * @date 2020/7/16 19:58
 */
//方式一是建造者模式的标准模式，除了上面的方式，还有一种常见的方式，可以解决使用多参数构造方法创建对象不够直观的问题。
public class TestBuilder {

    public static void main(String[] args) {
        //建造自定义电脑（链式调用）
        CustomComputer customComputer = CustomComputer.builder()
                .cpu("i7 7500")
                .board("华硕 B250")
                .ram("金士顿 8G")
                .build();
        System.out.println(customComputer);
    }
}

