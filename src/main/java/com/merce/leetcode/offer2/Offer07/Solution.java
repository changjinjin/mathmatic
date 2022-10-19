package com.merce.leetcode.offer2.Offer07;

import com.merce.leetcode.offer2.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 07. 重建二叉树
public class Solution {
    //方法一：递归
    private static Map<Integer, Integer> indexMap;
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right){
            return null;
        }
        int preorder_root = preorder_left;
        int inorder_root = indexMap.get(preorder[preorder_root]);
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode.toString());
    }
}
