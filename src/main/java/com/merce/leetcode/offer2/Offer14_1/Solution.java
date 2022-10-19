package com.merce.leetcode.offer2.Offer14_1;
//剑指 Offer 14- I. 剪绳子
//2 <= n <= 58
public class Solution {
    public static void main(String[] args) {
        int num = cuttingRope(10);
        System.out.println("num = " + num);
    }

    // 10
    // 3 3 4 = 36 | 2 2 2 2 2 = 32
    //数学推导 / 贪心思想
//    public static int cuttingRope(int n) {
//        if(n <= 3){
//            return n - 1;
//        }
//        int a = n / 3;
//        int b = n % 3;
//        if(b == 0){
//            return (int) Math.pow(3, a);
//        }
//        if(b == 1){
//            return (int) Math.pow(3, a - 1) * 4;
//        }
//        return (int) (Math.pow(3, a) * 2);
//    }

    //方法一：动态规划
//    public static int cuttingRope(int n) {
//        int[] dp = new int[n + 1];
//        for(int i = 2; i <= n; i++) {
//            int curMax = 0;
//            for(int j = 1; j < i; j++){
//                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
//            }
//            dp[i] = curMax;
//        }
//        return dp[n];
//    }

    /*
        dp五部曲:
        1.状态定义:dp[i]为长度为i的绳子剪成m段最大乘积为dp[i]
        2.状态转移:dp[i]有两种途径可以转移得到
            2.1 由前一个dp[j]*(i-j)得到,即前面剪了>=2段,后面再剪一段,此时的乘积个数>=3个
            2.2 前面单独成一段,后面剩下的单独成一段,乘积为j*(i-j),乘积个数为2
            两种情况中取大的值作为dp[i]的值,同时应该遍历所有j,j∈[1,i-1],取最大值
        3.初始化:初始化dp[1]=1即可
        4.遍历顺序:显然为正序遍历
        5.返回坐标:返回dp[n]
        */

    //方法一：动态规划
//    public static int cuttingRope(int n) {
//        // 定义dp数组
//        int[] dp = new int[n + 1];
//        // 初始化dp[1]
//        dp[1] = 1; // 指长度为1的单独乘积为1
//        // 遍历[2,n]的每个状态
//        for(int i = 2; i <= n; i++){
//            for(int j = 1; j < i; j++){
//                // 求出两种转移情况(乘积个数为2和2以上)的最大值
//                int temp = Math.max(dp[j] * (i - j), j * (i - j));
//                dp[i] = Math.max(temp, dp[i]);
//            }
//        }
//        return dp[n];
//    }

    //贪心算法
    //循环求余
    public static int cuttingRope(int n) {
        if(n <= 3){
            return n - 1;
        }
        int res = 1;
        while(n > 4){
            res = res * 3;
            n -= 3;
        }
        return res * n;
    }
}
