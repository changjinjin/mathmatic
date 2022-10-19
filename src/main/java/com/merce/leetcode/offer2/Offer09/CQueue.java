package com.merce.leetcode.offer2.Offer09;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//剑指 Offer 09. 用两个栈实现队列
public class CQueue {
    //方法一：双栈
//    private Deque<Integer> inStack;
//    private Deque<Integer> outStack;
//
//    public CQueue() {
//        inStack = new ArrayDeque<Integer>();
//        outStack = new ArrayDeque<Integer>();
//    }
//
//    public void appendTail(int value) {
//        inStack.push(value);
//    }
//
//    public int deleteHead() {
//        if(outStack.isEmpty()){
//            if(inStack.isEmpty()){
//                return -1;
//            }
//            in2out();
//        }
//        return outStack.pop();
//    }
//
//    private void in2out() {
//        while(!inStack.isEmpty()){
//            outStack.push(inStack.pop());
//        }
//    }

    private LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if(!B.isEmpty()){
            return B.removeLast();
        }
        if(A.isEmpty()){
            return -1;
        }
        while(!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
