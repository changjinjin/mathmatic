package com.merce.leetcode.offer2.Offer10_1;
//剑指 Offer 10- I. 斐波那契数列
public class Solution {
    // 方法一：动态规划
    public static int fib(int n) {
        final int MOD = 1000000007;
        if(n < 2){
            return n;
        }
        int p = 0;
        int q = 0;
        int r = 1;
        for(int i = 2; i <= n; i++){
            p = q;
            q= r;
            r = (p + q) % MOD;
        }
        return r;
    }

//    public static int fib(int n) {
//        final int MOD = 1000000007;
//        int a = 0;
//        int b = 1;
//        int sum;
//        for(int i = 0; i < n; i++){
//            sum = (a + b) % MOD;
//            a = b;
//            b = sum;
//        }
//        return a;
//    }

    public static void main(String[] args) {
        int res = fib(5);
        System.out.println(res);
    }
}
