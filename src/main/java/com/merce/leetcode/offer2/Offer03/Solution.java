package com.merce.leetcode.offer2.Offer03;

import java.util.HashSet;
import java.util.Set;

//剑指 Offer 03. 数组中重复的数字
public class Solution {
//    public int findRepeatNumber(int[] nums){
//        Set<Integer> dic = new HashSet<>();
//        for(int num : nums) {
//            if(dic.contains(num)) return num;
//            dic.add(num);
//        }
//        return -1;
//    }

    public int findRepeatNumber(int[] nums){
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for(int num : nums){
            if(!set.add(num)){
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
