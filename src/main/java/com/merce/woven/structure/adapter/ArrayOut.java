package com.merce.woven.structure.adapter;

import java.util.Random;
import java.util.UUID;

/**
 * 原有系统的接口（返回值为字符串数组）
 */
public class ArrayOut {
    /**
     * 获取字符串数组
     *
     * @return
     */
    public String[] getStrings(){
        String[] strings = new String[new Random().nextInt(10) + 1];
        for (int i = 0; i < strings.length; i++){
            strings[i] = UUID.randomUUID().toString()
                    .replace("-", "")
                    .substring(0, 5).toUpperCase();
        }
        return strings;
    }
}
