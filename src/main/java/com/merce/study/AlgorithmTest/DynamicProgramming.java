package com.merce.study.AlgorithmTest;

/**
 * @ClassName DynamicProgramming
 * @Deacription 动态规划(背包最优解)
 * @Author Administrator
 * @Date 2021/1/4 17:05
 * @Version 1.0
 **/
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] w = new int[]{0 , 2 , 3 , 4 , 5}; //商品的体积2、3、4、5
        int[] v = {0 , 3 , 4 , 5 , 6}; //商品的价值3、4、5、6
        int bagV = 8;//背包大小
        int[][] dp={{0}};//动态规划表
        int[] item = {0, 0, 0, 0, 0};
        getDynamicProgramming(w, v, bagV, dp);
//        findWhat(4, 8, dp, item);

    }

/*    private static void findWhat(int i, int j, int[][] dp, int[] item) {
        if(j > 1){
            if (dp[i][j] == dp[i - 1][j]) {
                item[i] = 0;
                findWhat(i - 1, j, dp, item);
            }else if(j - w[i] >= 0 && dp[i][j] == dp[i - 1][j - w[i]] + v[i]){
                item[i] = 1;
                findWhat(i - 1, j - w[i]);
            }
        }
    }*/

    private static void getDynamicProgramming(int[] w, int[] v, int bagV, int[][] dp) {
        for(int i = 1; i <= 4; i++){
            for (int j = 1; j <= bagV; j++) {
                if(j < w[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        //动态规划表的输出
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 9; j++){
                //
            }
        }
    }
}
