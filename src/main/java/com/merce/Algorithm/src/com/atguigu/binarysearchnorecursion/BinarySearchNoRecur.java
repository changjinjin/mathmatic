package com.merce.Algorithm.src.com.atguigu.binarysearchnorecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinarySearchNoRecur
 * @Deacription 二分查找
 * @Author Administrator
 * @Date 2020/12/29 19:09
 * @Version 1.0
 **/
public class BinarySearchNoRecur {
    public static void main(String[] args) {

        int[] arr = {1,3, 8, 10, 11, 67, 100,100,100};
        //1、非递归
        int index_no_recursion = binarySearch_no_recursion(arr,100);
        //2、递归
        int index_recursion = binarySearch_recursion(arr, 0, arr.length - 1,  100);
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 100);

        System.out.println("index_no_recursion=" + index_no_recursion);
        System.out.println("index_recursion=" + index_recursion);
        System.out.println("resIndexList=" + resIndexList);
    }

    private static List<Integer> binarySearch2(int[] arr, int left, int right, int target) {
        if(left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        if(target > arr[mid]){
            return binarySearch2(arr, mid + 1, right, target);
        }else if(target < arr[mid]){
            return binarySearch2(arr, left, mid - 1, target);
        }else{
            List<Integer> resIndexlist = new ArrayList<Integer>();
            int temp = mid - 1;
            while(true){
                if(temp < 0 || arr[temp] != target){
                    break;
                }
                resIndexlist.add(temp);
                temp = temp - 1;
            }
            //添加mid
            resIndexlist.add(mid);
            temp = mid + 1;
            while(true){
                if(temp > arr.length - 1 || arr[temp] != target){
                    break;
                }
                resIndexlist.add(temp);
                temp = temp + 1;
            }
            return resIndexlist;
        }
    }

    private static int binarySearch_recursion(int[] arr, int left, int right, int target) {
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(target > arr[mid]){
            return binarySearch_recursion(arr, mid + 1, right, target);
        }else if(target < arr[mid]){
            return binarySearch_recursion(arr, left, mid - 1, target);
        }else{
            return mid;
        }
    }

    private static int binarySearch_no_recursion(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
