package com.dongyin.leetcode;

import org.springframework.core.NamedInheritableThreadLocal;

import java.util.*;
import java.util.logging.Handler;

/**
 * @author dystart
 * @create 2022-03-30 1:58
 */
public class Solution {
     class ListNode {
         int val;
         ListNode next;

         ListNode() {
         }

         ListNode(int val) {
             this.val = val;
         }

         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
     }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         //虚拟头节点
        ListNode dummy = new ListNode(-1),p=dummy;
        ListNode p1=l1,p2=l2;
        while (p1!=null&&p2!=null){
            if (p1.val>=p2.val){
                p.next=p2;
            }else {
                p.next=p1;
            }
            p=p.next;
        }
        if (p1==null){
            p.next=p2;
        }
        if (p2==null){
            p.next=p1;
        }
        return p;
    }

    public ListNode mergeKLists(ListNode[] lists) {
         if (lists.length==0)return null;
         ListNode dummy = new ListNode(-1),p=dummy;
         //队列的大小为lists.length，优先级是ListNode.val最小的先进
        Queue<ListNode> pq = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val-o2.val);
        for (ListNode list : lists) {
            pq.offer(list);
        }

        while (!pq.isEmpty()){
            ListNode poll = pq.poll();
            p.next=poll;
            p=p.next;
            poll=poll.next;
            if (poll!=null){
                pq.offer(poll);
            }
        }
        return dummy.next;

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode p1 = head,p2=head,dummy=p2;
        for (int i = 0; i < n; i++) {
            p1=p1.next;
        }
        if(p1==null){
            return dummy.next;
        }
        while (p1.next!= null){
            p2=p2.next;
            p1=p1.next;
        }
        p2.next=p2.next.next;
        return dummy;
    }

    public ListNode middleNode(ListNode head) {
         ListNode fast = head,slow=head;
         while (fast.next!=null){
             fast=fast.next;
             if (fast.next==null){
                 return slow.next;
             }
             fast=fast.next;
             slow=slow.next;
         }
         return slow;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode p1=headA,p2=headB;
//        Set<ListNode> listNodes = new HashSet<>();
//        while (p1!=null){
//            listNodes.add(p1);
//            p1=p1.next;
//        }
//        while (p2!=null){
//            if (listNodes.contains(p2)){
//                return p2;
//            }
//            p2=p2.next;
//        }
//        return null;


        ListNode p1=headA,p2=headB;
        while (p1!=p2){
            if (p1==null){
                p1=headB;
            }else {
                p1=p1.next;
            }
            if (p2==null){
                p2=headA;
            }else {
                p2=p2.next;
            }
        }
        return p2;
    }

    public boolean hasCycle(ListNode head) {
         ListNode p1 = head,p2=head;
         while (p1!=null&&p2!=null){
             p1=p1.next;
             if (p1.next!=null){
                 p1=p1.next;
             }
             p2=p2.next;
             if (p1==p2&&p2!=null){
                 return true;
             }
         }
         return false;
    }


    public ListNode detectCycle(ListNode head) {
         ListNode p1=head,p2=head;
         int res=0;
         while (p1!=null&&p2!=null){
             p1=p1.next;
             if (p1!=null&&res==0){
                 p1=p1.next;
             }
             p2=p2.next;
             if (p1==p2&&p1!=null){
                 if (res==0) {
                     if (p1!=head) {
                         p2 = head;
                         res++;
                     }
                     return p1;
                 }else {
                     return p1;
                 }
             }
         }
         return null;
    }


    public ListNode deleteDuplicates(ListNode head) {
         if (head==null) return null;
         ListNode fast=head,slow=head;
         while (fast!=null){
             if (fast.val!=slow.val){
                 slow.next=fast;
                 slow=slow.next;
             }
             fast=fast.next;
         }
         slow.next=null;
         return head;
    }
}
