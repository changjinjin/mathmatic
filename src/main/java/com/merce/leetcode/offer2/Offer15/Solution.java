package com.merce.leetcode.offer2.Offer15;
//剑指 Offer 15. 二进制中1的个数
public class Solution {
    public static void main(String[] args) {
        int num = hammingWeight(11);
        System.out.println("num = " + num);
    }

    //方法一：逐位判断
//    public static int hammingWeight(int n) {
//        int res = 0;
//        while(n != 0){
//            res += n & 1;
//            n >>>= 1;
//        }
//        return res;
//    }

    //方法二：巧用 n & (n - 1)
//(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
//n & (n - 1) 解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。

//    public static int hammingWeight(int n) {
//        int res = 0;
//        while(n != 0){
//            res++;
//            n &= n - 1;
//        }
//        return res;
//    }


    //方法一：循环检查二进制位
//    public static int hammingWeight(int n) {
//        int res = 0;
//        for(int i = 0; i < 32; i++){
//            if((n & (1 << i)) != 0){
//                res++;
//            }
//        }
//        return res;
//    }

    //方法二：位运算优化
    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            n &= n - 1;
            res++;
        }
        return res;
    }
}
