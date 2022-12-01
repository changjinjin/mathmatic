package com.merce.leetcode.offer2.Offer12;

//剑指 Offer 12. 矩阵中的路径
public class Solution {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean exist = exist(board, word);
        System.out.println("exist: " + exist);
    }

    //深度优先搜索（DFS）+ 剪枝
    private static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, words, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                System.out.print(board[m][n] + " ");
            }
        }

        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]){
            return false;
        }
        if(k == word.length - 1){
            return true;
        }
        board[i][j] = '\0'; //已经遍历过的元素标记为不可用
        boolean res = dfs(board, word, i + 1, j, k + 1) || //下
                      dfs(board, word, i - 1, j, k + 1) || //上
                      dfs(board, word, i, j + 1, k + 1) || //右
                      dfs(board, word, i, j - 1, k + 1);   //左
        board[i][j] = word[k]; //元素查询过以后再替换为原来的值
        return res;
    }
}
