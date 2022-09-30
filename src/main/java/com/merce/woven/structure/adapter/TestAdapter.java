package com.merce.woven.structure.adapter;

/**
 * 测试适配器模式
 */
public class TestAdapter {
    public static void main(String[] args) {
        ArrayOut arrayOut = new ArrayOut();
        ListOut listOut = new ArrayAdapter(arrayOut);
        listOut.getStringList().stream().forEach(s -> System.out.println(s));
    }
}
