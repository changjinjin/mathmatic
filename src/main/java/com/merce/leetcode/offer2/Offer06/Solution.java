package com.merce.leetcode.offer2.Offer06;

import com.merce.leetcode.offer2.util.ListNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//面试题06. 从尾到头打印链表（递归法、辅助栈法，清晰图解）
public class Solution {
    //方法一：递归法
//    List<Integer> tmp = new ArrayList<Integer>();
//    public int[] reversePrint(ListNode head) {
//        resur(head);
//        int[] res = new int[tmp.size()];
//        for(int i = 0; i < res.length; i++){
//            res[i] = tmp.get(i);
//        }
//        return res;
//    }
//
//    private void resur(ListNode head) {
//        if(head == null){
//            return;
//        }
//        resur(head.next);
//        tmp.add(head.val);
//    }

    //方法二：辅助栈法
//    public int[] reversePrint(ListNode head) {
//        LinkedList<Integer> stack = new LinkedList<Integer>();
//        while(head != null){
//            stack.addLast(head.val);
//            head = head.next;
//        }
//
//        int[] res = new int[stack.size()];
//        for(int i = 0; i < res.length; i++){
//            res[i] = stack.removeLast();
//        }
//        return res;
//    }


    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for(int i = 0; i < size; i++){
            print[i] = stack.pop().val;
        }
        return print;
    }
}
