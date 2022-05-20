package com.dongyin.leetcode;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author dystart
 * @create 2022-04-04 16:18
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public int test() throws Exception {
        Stack<Object> stack = new Stack<>();
        stack.pop();
        if (false) {
            throw new Exception("hhh");
        }
        return 0;
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = new TreeNode();
        temp=root.left;
        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }


    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        traverser(root.left,root.right);
        return root;
    }

    void traverser(Node left,Node right){
        if (left==null||right==null){
            return;
        }
        left.next=right;
        traverser(left.left,left.right);
        traverser(right.left,right.right);
        traverser(left.right,right.left);
    }



    public void flatten(TreeNode root) {
        if (root==null){return;}
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left=null;
        root.right=left;
        TreeNode p =root;
        while (p.right!=null){
            p=p.right;
        }
        p.right=right;
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = build(nums, 0, nums.length - 1);
        return root;
    }

    TreeNode build(int[] nums,int lo,int hi){
        if(lo>hi){
            return null;
        }
        int max=Integer.MIN_VALUE,maxIndex=-1;
        for (int i = lo; i < hi; i++) {
            if(nums[i]>max){
                max=nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums,lo,maxIndex-1);
        root.right = build(nums,maxIndex+1,hi);
        return root;
    }


    HashMap<Integer,Integer> inorderMap=new HashMap<>();
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    TreeNode build1(int[] preorder,int startPer ,int endPer,
                   int[] inorder, int startIn,int endIn){
        if (startPer>endPer){
            return null;
        }
        int Val = preorder[startPer];
        TreeNode root = new TreeNode(Val);
        Integer index = inorderMap.get(Val);
        int leftSize=index-startIn;
        root.left=build(preorder,startPer+1,leftSize+startPer,
                inorder,startIn,index-1);
        root.right=build(preorder,leftSize+startPer+1,endPer,
                inorder,index+1,endIn);
        return root;
    }





    Map<Integer ,Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    TreeNode build(int[] inorder,int startIn ,int endIn,
                   int[] postorder, int startPost,int endPost){
        if (startIn>endIn){
            return null;
        }
        int Val = postorder[endPost];
        TreeNode root = new TreeNode(Val);
        Integer index = inMap.get(Val);
        int leftSize=index-startIn;
        root.left=build(inorder,startIn,index-1,
                postorder,startPost,startPost+leftSize-1);
        root.right=build(inorder,index+1,endIn,
                postorder,startPost+leftSize,endPost-1);
        return root;
    }
}
