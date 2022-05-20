package com.dongyin.leetcode;

import org.junit.Test;

import java.awt.geom.QuadCurve2D;
import java.util.*;

/**
 * @author dystart
 * @create 2022-03-29 19:08
 */
public class OpenLock {

    String upOne(String up,int i){
        char[] chars = up.toCharArray();
        if (chars[i]=='9'){
            chars[i]='0';
        }else {
            chars[i]+=1;
        }
        return new String(chars);
    }

    String downOne(String up,int i){
        char[] chars = up.toCharArray();
        if (chars[i]=='0'){
            chars[i]='9';
        }else {
            chars[i]-=1;
        }
        return new String(chars);
    }


    int openLock(String[] deadends, String target) {
        //不可能答案
        Set<String> strings = new HashSet<>();
        for (String deadend : deadends) {
            strings.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        //回头路
        Set<String> visited = new HashSet<>();

        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()){
            //一层的可能结果
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (strings.contains(poll)){
                    continue;
                }
                if(poll.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String s = upOne(poll, j);
                    if(!visited.contains(s)){
                        queue.offer(s);
                        visited.add(s);
                    }
                    String downOne = downOne(poll, j);
                    if(!visited.contains(downOne)){
                        queue.offer(downOne);
                        visited.add(downOne);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    //最大深度
    int res=0;
    int depth = 0;
//    public int maxDepth(TreeNode1.TreeNode root) {
////        traverse(root);
////        return res;
//
//        if (root==null){
//            return 0;
//        }
//        int leftMax = maxDepth(root.left);
//        int rightMax = maxDepth(root.right);
//        int res = Math.max(leftMax,rightMax)+1;
//        return res;
//    }

    void traverse(TreeNode1.TreeNode root){
        if (root.left==null&&root.right==null){
            res=Math.max(res,depth);
            return;
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    @Test
    public void test(){
        LinkedList<Integer> integers1 = new LinkedList<>();
        integers1.add(7);
        integers1.add(5);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.addAll(integers1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public List<Integer> preorderTraversal(TreeNode1.TreeNode root) {
        List<Integer> integers = new LinkedList<>();
        if (root==null){
            return integers;
        }
        integers.add(root.val);
        integers.addAll(preorderTraversal(root.left));
        integers.addAll(preorderTraversal(root.right));
        return integers;
    }


    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode1.TreeNode root) {
        // 对每个节点计算直径，求最大直径
        traverse1(root);
        return maxDiameter;
    }

    // 遍历二叉树
    void traverse1(TreeNode1.TreeNode root) {
        if (root==null) {
            return;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        traverse1(root.left);
        traverse1(root.right);
    }

    // 计算二叉树的最大深度
    int maxDepth(TreeNode1.TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int ringtDepth = maxDepth(root.right);
        int myDiameter = leftDepth+ringtDepth;
        maxDiameter=Math.max(myDiameter,maxDiameter);
        return Math.max(leftDepth,ringtDepth);
    }
}
