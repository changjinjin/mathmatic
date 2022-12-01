package com.merce.leetcode.offer2.Offer10_2;
//剑指 Offer 10- II. 青蛙跳台阶问题
public class Solution {
//    public static int numWays(int n) {
//        int a = 1;
//        int b = 1;
//        int sum;
//        for(int i = 0; i < n; i++) {
//            sum = (a + b) % 1000000007;
//            a = b;
//            b = sum;
//        }
//        return a;
//    }

    public static int numWays(int n) {
        final int MOD = 1000000007;
        if(n == 0){
            return 1;
        }
        int p = 1;
        int q = 1;
        int r = 1;
        for(int i = 1; i < n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }

    public static void main(String[] args) {
        int res = numWays(7);
        System.out.println(res);
    }
}
