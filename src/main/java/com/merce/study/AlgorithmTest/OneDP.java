package com.merce.study.AlgorithmTest;

/**
 * @ClassName OneDP
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/12/30 12:28
 * @Version 1.0
 **/

//问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class OneDP {
    public static void main(String[] args) {
        //(1)、定义数组元素的含义
        //跳上一个 i 级的台阶总共有 dp[i] 种跳法
        //(2）、找出数组元素间的关系式
        //(3）、找出初始条件
        int num = findSolutionNum(3);
        System.out.println(num);
    }

    private static int findSolutionNum(int i) {
        if(i <= 1){
            return 1;
        }
        int[] dp = new int[i + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int n = 3; n <= i; n++){
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[i];
    }
}
