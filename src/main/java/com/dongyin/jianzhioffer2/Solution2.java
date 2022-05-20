package com.dongyin.jianzhioffer2;

import org.springframework.beans.factory.FactoryBean;

import java.util.Stack;

/**
 * @author dystart
 * @create 2022-05-09 21:24
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }




    public int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }




    public int hammingWeight(int n) {
        if(n==0) return 0;
        if (n<0)n=-n;
        int mod;
        int NumRes=0;
        while (n!=0){
            mod=n%2;
            NumRes+=mod;
            n=n/2;
        }

        return NumRes;
    }




    public int[] printNumbers(int n) {
        int max= (int) (Math.pow(10,n)-1);
        int[] ints = new int[max];
        for (int i = 0; i < max; i++) {
            ints[i]=i+1;
        }
        return ints;
    }





    public ListNode deleteNode(ListNode head, int val) {
        ListNode p1=head;
        if (p1.val==val)return head.next;
        while (p1.next!=null){
            if (p1.next.val==val){
                p1.next=p1.next.next;
            }
            p1=p1.next;
            if (p1==null)break;
        }
        return head;
    }
}


class CQueue {

    Stack stack1;
    Stack stackres;

    public CQueue() {
        stack1=new Stack();
        stackres=new Stack();
    }

    public void appendTail(int value) {
        stackres.push(value);
    }

    public int deleteHead(){
        if (stackres.size()==0)return -1;
        while (!stackres.empty()){
            stack1.push(stackres.pop());
        }
        int res=(Integer) stack1.pop();
        while (!stack1.empty()){
            stackres.push(stack1.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.fib(48));
    }



    int fib(int n) {
        final int MOD = 1000000007;
        // 备忘录全初始化为 0
        long[] memo = new long[n + 1];
        // 进行带备忘录的递归
        return (int) (helper(memo, n)%MOD);
    }

    long helper(long[] memo, int n) {
        final int MOD = 1000000007;
        // base case
        if (n == 0 || n == 1) return n;
        // 已经计算过，不用再计算了
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1)%MOD + helper(memo, n - 2)%MOD;
        return memo[n];
    }





    int memo[];
    public int numWays(int n) {
        memo=new int[n+1];
        return ways(memo,n);
    }

    //对于n个台阶，只要确保最后一位是1或者2，对于n-1和n-2进行计算
    public int ways(int[] memo,int n){
        final int MOD = 1000000007;
        if (n==0||n==1)memo[n] =1;
        if (memo[n]!=0){
            return memo[n];
        }
        memo[n]= (ways(memo,n-1)%MOD+ways(memo,n-2)%MOD)%MOD;
        return memo[n];
    }

}
