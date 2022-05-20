package com.dongyin.jianzhioffer;

import java.util.*;

/**
 * @author dystart
 * @create 2022-04-23 17:26
 */
public class Solution4 {

    //headA走完整个再走B不同的，headB走完整个再走A不同的
    //相当于两个都走了两个不同的加一组相同的，结下了就是相交的起点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1=headA,p2=headB;
        while (p1!=p2){
            p1=p1==null?headB:p1.next;
            p2=p2==null?headA:p2.next;
        }
        return p1;
    }

    //38单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ints = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        return null;
    }


    //75
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return null;
    }

    public static void main(String[] args) {
        int[] ints= {2,3,1,3,2,4,6,7,9,2,19};

    }


    //反转链表
    public ListNode reverseList(ListNode head) {
        //用p当指针
        ListNode p=head;
        Stack<ListNode> stack = new Stack<>();
        while (p!=null){
            stack.push(p);
            p=p.next;
        }
        ListNode q= new ListNode();
        //用res当指针
        ListNode res=q;
        while (stack.size()>0){
            res.next= stack.pop();
            res=res.next;
        }
        res.next=null;
        return q.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
}

