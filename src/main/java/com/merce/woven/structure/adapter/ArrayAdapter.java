package com.merce.woven.structure.adapter;

import java.util.Arrays;
import java.util.List;

/**
 * 适配器类（将数据的返回结果转换（适配）为集合）
 */
public class ArrayAdapter implements ListOut{
    private transient ArrayOut arrayOut;
    public ArrayAdapter(ArrayOut arrayOut) {
        this.arrayOut = arrayOut;
    }
    @Override
    public List<String> getStringList() {
        String[] strings = arrayOut.getStrings();
        return Arrays.asList(strings);
    }
}
