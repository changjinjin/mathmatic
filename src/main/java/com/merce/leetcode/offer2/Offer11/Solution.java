package com.merce.leetcode.offer2.Offer11;
//剑指 Offer 11. 旋转数组的最小数字
public class Solution {
    //方法一：二分查找
//    public static int minArray(int[] numbers) {
//        int low = 0;
//        int high = numbers.length - 1;
//        while(low < high){
//            int pivot = low + (high - low) / 2;
//            if(numbers[pivot] < numbers[high]){
//                high = pivot;
//            }else if(numbers[pivot] > numbers[high]){
//                low = pivot + 1;
//            }else{
//                high -= 1;
//            }
//        }
//        return numbers[low];
//    }

//    public static int minArray(int[] numbers) {
//        int i = 0;
//        int j = numbers.length - 1;
//        while(i < j){
//            int m = (i + j) / 2;
//            if(numbers[m] > numbers[j]){
//                i = m + 1;
//            }else if(numbers[m] < numbers[j]){
//                j = m;
//            }else{
//                j--;
//            }
//        }
//        System.out.println("i = " + i + " j = " + j);
//        return numbers[i];
//    }

    public static int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int m = (i + j) / 2;
            if(numbers[m] > numbers[j]){
                i = m + 1;
            }else if(numbers[m] < numbers[j]){
                j = m;
            }else{
                //j--;
                //对于寻找此类数组的最小值问题，可直接放弃二分查找，而使用线性查找替代
                int x = i;
                for(int k = i + 1; k < j; k++){
                    if(numbers[k] < numbers[x]){
                        x = k;
                    }
                }
                return numbers[x];
            }
        }
        System.out.println("i = " + i + " j = " + j);
        return numbers[i];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,2,2,4,0,1};
        int minNum = minArray(numbers);
        System.out.println(minNum);
    }
}

//3,4,5,1,2
//2,2,2,0,1