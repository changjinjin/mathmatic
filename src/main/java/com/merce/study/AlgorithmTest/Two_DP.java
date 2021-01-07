package com.merce.study.AlgorithmTest;

/**
 * @ClassName Two_DP
 * @Deacription TODO
 * @Author Administrator
 * @Date 2021/1/4 12:16
 * @Version 1.0
 **/

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//问总共有多少条不同的路径？
public class Two_DP {
    public static void main(String[] args) {
        /*int m = 5;
        int n = 8;
        int num = uniquePaths(m, n);
        System.out.println(num);*/

        /*int[][] arr = {{1, 3, 1},{1, 5, 1},{4, 2, 1}};
        int minSum = uniquePaths_minSum(arr);*/

        String word1 = "heworfg";
        String word2 = "helloworld";
        int minDistanceLength = minDistance(word1, word2);
        System.out.println(minDistanceLength);
    }

    private static int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // dp[0][0...n2]的初始值
        for(int j = 1; j <= n2; j++){
            dp[0][j] = dp[0][j - 1] + 1;
        }
        // dp[0...n1][0] 的初始值
        for(int i = 0; i <= n1; i++){
            dp[i][0] = dp[i-1][0] + 1;
        }

        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    private static int minDistance_optimization(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();
        int[] dp = new int[n2 + 1];
        // dp[0...n2]的初始值
        for (int j = 0; j <= n2; j++){
            dp[j] = j;
        }
        // dp[j] = min(dp[j-1], pre, dp[j]) + 1
        for (int i = 1; i <= n1; i++) {
            int temp = dp[0];
            // 相当于初始化
            dp[0] = i;
            for (int j = 1; j <= n2; j++) {
                // pre 相当于之前的 dp[i-1][j-1]
                int pre = temp;
                temp = dp[j];
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[j] = pre;
                }else {
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
                }
                // 保存要被抛弃的值
            }
        }
        return dp[n2];
    }

    /*public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // dp[0][0...n2]的初始值
        for (int j = 1; j <= n2; j++)
            dp[0][j] = dp[0][j - 1] + 1;
        // dp[0...n1][0] 的初始值
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;
        // 通过公式推出 dp[n1][n2]
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }*/

    private static int uniquePaths_minSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        if(m <= 0 && n <= 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        // 初始化最左边的列
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        // 初始化最上边的行
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        // 推导出 dp[m-1][n-1]
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        //初始化
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }

        // 推导出 dp[m-1][n-1]
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    private static int uniquePaths_optimization(int m, int n) {

        if(m <= 0 || n <= 0){
            return 0;
        }
        int[] dp = new int[n];
        //初始化
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }

        // 公式：dp[i] = dp[i-1] + dp[i]
        for (int i = 1; i < m; i++) {
            // 第 i 行第 0 列的初始值
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];
    }
}
