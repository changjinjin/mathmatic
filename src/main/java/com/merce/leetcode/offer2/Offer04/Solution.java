package com.merce.leetcode.offer2.Offer04;
//面试题04. 二维数组中的查找（标志数）
public class Solution {
//    public boolean findNumberIn2DArray(int[][] matrix, int target){
//        int i = matrix.length - 1;
//        int j = 0;
//        while(i >= 0 && j < matrix[0].length){
//            if(matrix[i][j] > target){
//                i--;
//            }else if(matrix[i][j] < target){
//                j++;
//            }else{
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while(x < m && y >= 0){
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                y--;
            }else{
                x++;
            }
        }
        return false;
    }
}
