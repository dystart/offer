package com.dongyin.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dystart
 * @create 2022-03-28 17:17
 */
public class TreeNode1 {
//    TreeNode right;
//    TreeNode left;
//
//    void traverse(TreeNode root) {
//        traverse(root.left);
//        traverse(root.right);
//    }

//    @Test
//    public int CoinChange(int[] coins,int mount){
//        int[] dp = new int[mount+1];
//        Arrays.fill(dp,mount+1);
//        dp[0]=0;
//        for (int i = 0; i < dp.length; i++) {
//            for (int coin : coins) {
//                if (i-coin<0){
//                    continue;
//                }
//                dp[i]=Math.min(dp[i],1+dp[i-coin]);
//            }
//        }
//        return (dp[mount]==mount+1)?-1:dp[mount];
//    }

//    List<List<Integer>> list = new LinkedList<List<Integer>>();
//    @Test
//    public List<List<Integer>> permute(int[] nums) {
//        //未进到路径中的全是false；
//        boolean[] used = new boolean[nums.length];
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(nums, track, used);
//        return list;
//    }
//
//    public void backtrack(int[] nums,List track,boolean[] used){
//        //跳出条件
//        if (list.size()==nums.length){
//            list.add(new LinkedList<>(track));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i]==true){
//                continue;
//            }
//            track.add(nums[i]);
//            used[i]=true;
//            backtrack(nums,track,used);
//            track.remove(i);
//            used[i]=false;
//        }
//
//    }


    List<List<Integer>> list = new LinkedList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
//未进到路径中的全是false；
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, used);
        return list;
    }

    public void backtrack(int[] nums, List track, boolean[] used) {
        //跳出条件
        if (list.size() == nums.length) {
            list.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.remove(i);
            used[i] = false;
        }

    }


    class TreeNode {
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
    }


    public int minDepth(TreeNode root) {
        if (root==null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth =1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            depth++;
        }
        return depth;
    }


}
