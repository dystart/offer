package com.dongyin.leetcode;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dystart
 * @create 2022-03-31 17:58
 */
public class Zuhe {


    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();


    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    public void  backtrack(int[] nums,int start){
         res.add(new LinkedList<Integer>(track));
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }


    List<List<Integer>> resCom = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> trackCom = new LinkedList<>();
    public void back(int start,int end, int k) {
        if (trackCom.size()==k){
            resCom.add(new LinkedList<>(trackCom));
        }
        for (int i = start; i <= end; i++) {
            trackCom.addLast(i);
            back(i+1,end,k);
            trackCom.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k){
        back(1,n,k);
        return resCom;
    }


    //不重复
    LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
    LinkedList<Integer> integers = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used=new boolean[nums.length];
        backPermute(nums);
        return list;
    }


    void backPermute(int[] nums){
        if (integers.size()==nums.length){
            list.add(new LinkedList<>(integers));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            integers.addLast(nums[i]);
            used[i]=true;
            backPermute(nums);
            integers.removeLast();
            used[i]=false;
        }
    }


    LinkedList<List<Integer>> subSec = new LinkedList<List<Integer>>();
    LinkedList<Integer> tractSec = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTract(nums,0);
        return subSec;
    }

    void backTract(int[] nums,int start){
        subSec.add(new LinkedList<>(tractSec));
        for (int i = start; i < nums.length; i++) {
            if(i>start&&nums[i]==nums[i+1]){continue;
            }
            tractSec.addLast(nums[i]);
            backTract(nums,i+1);
            tractSec.removeLast();
        }
    }



    List<List<Integer>> resSum2 = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> trackSum2 = new LinkedList<>();
    // 记录 track 中的元素之和
    int trackSum = 0;
    //[10,1,2,7,6,1,5]  8
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backSum2(candidates,target,0);
        return resSum2;
    }

    void backSum2(int[] candidates, int target,int start){
        if (trackSum==target){
            resSum2.add(new LinkedList<>(trackSum2));
        }
        // base case，超过目标和，直接结束
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i>start&&candidates[i-1]==candidates[i]){
                continue;
            }
            trackSum2.addLast(candidates[i]);
            trackSum+=candidates[i];
            backSum2(candidates,target,i+1);;
            trackSum2.removeLast();
            trackSum-=candidates[i];
        }
    }
}
