package com.merce.leetcode.offer2.Offer14_2;
//剑指 Offer 14- II. 剪绳子 II
//面试题14- II. 剪绳子 II（数学推导 / 贪心思想 + 快速幂求余，清晰图解）
//此题与 面试题14- I. 剪绳子 主体等价，唯一不同在于本题目涉及 “大数越界情况下的求余问题”
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
public class Solution {

    public static void main(String[] args) {
        int res = cuttingRope(100);
        System.out.println("res = " + res);
    }

    //贪心算法
    //循环求余
    public static int cuttingRope(int n) {
        if(n <= 3){
            return n - 1;
        }
        long res = 1L;
        //int p = 1000000007;
        int p = (int) (1e9 + 7);
        //贪心算法，优先切三，其次切二
        while(n > 4){
            res = res * 3 % p;
            n -= 3;
        }
        return (int) (res * n % p);
    }
}
