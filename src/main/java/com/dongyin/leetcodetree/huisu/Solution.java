package com.dongyin.leetcodetree.huisu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯排列组合子集
 *组合，可复选不需要used[]
 *     * 元素无重可复选
 *     * 组合不需要回头
 * @author dystart
 * @create 2022-04-15 15:55
 */
public class Solution {

    //子集，元素不重复不可复选
    /*
     * 两个集合一个子序列集合，一个所可能集合
     * 回溯一定是有取有出的过程，判断什么时候出
     *
     *
     *
     * */
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start) {
        res.add(new LinkedList<Integer>(track));
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }


    /*
     * 组合，元素无重不复选，初到末k个数的组合
     *
     *
     * */
    List<List<Integer>> resCom = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> trackCom = new LinkedList<>();

    public void back(int start, int end, int k) {
        if (trackCom.size() == k) {
            resCom.add(new LinkedList<>(trackCom));
            return;
        }
        for (int i = start; i <= end; i++) {
            trackCom.addLast(i);
            back(i + 1, end, k);
            trackCom.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        back(1, n, k);
        return resCom;
    }




    /*
    * 排列，元素无重不可复选
    * 排列不像组合那样只需要往前走，1，2和2，1是不同的排列
    * 所以要保证排列的时候和自己复选，所以需要备注一下，进入队列的不能进，
    * 进一个改为true，出一个改为false
    * */
    //不重复
    LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
    LinkedList<Integer> integers = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        //默认为false
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



    /*子集，组合是等价的
    * 元素可重不可复选
    *有重复，所以需要将原数组排序，，判断是不是第二次以上出现，不计算这次的
    * 其余和子集问题一样
    * 组合就是看几个一组或者和为多少加一个判断
    * */
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
            if(i>start&&nums[i-1]==nums[i]){
                continue;
            }
            tractSec.addLast(nums[i]);
            backTract(nums,i+1);
            tractSec.removeLast();
        }
    }


    /*
    * 元素可重不复选的排列
    * 可重不复选所以需要数组记录有没有进队列，还有排序
    * 排列所以从第一个元素开始
    * */
    List<List<Integer>> resPa = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> trackPa = new LinkedList<>();
    // 记录 track 中的元素之和
    //全排列
    boolean usedPa[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        usedPa = new boolean[nums.length];
        Arrays.sort(nums);
        backUnique(nums);
        return resPa;
    }

    void backUnique(int[] nums){
        if (trackPa.size()==nums.length){
            resPa.add(new LinkedList<>(trackPa));
        }
        for (int i = 0; i < nums.length; i++) {
            //前一个进，但和当前元素一样，则不计数
            if(i>0&&nums[i-1]==nums[i]&&usedPa[i-1]){
                continue;
            }
            //防止当前元素再进
            if (usedPa[i]) {
                continue;
            }else {
                trackPa.addLast(nums[i]);
                usedPa[i] =true;
            }
            backUnique(nums);
            trackPa.removeLast();
            usedPa[i]=false;
        }
    }





    /*组合，可复选不需要used[]
    * 元素无重可复选
    * 组合不需要回头
    * */
    //无重复，可无限使用
    List<List<Integer>> resSum = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> trackSum = new LinkedList<>();
    // 记录 track 中的元素之和
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backCombination(candidates,target,0);
        return resSum;
    }

    void backCombination(int[] candidates,int target,int start){
        if (sum==target){
            resSum.add(new LinkedList<>(trackSum));
            return;
        }
        if (sum>target){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            trackSum.addLast(candidates[i]);
            sum+=candidates[i];
            //只需要将自己再次加入进去即可
            backCombination(candidates,target,i);
            trackSum.removeLast();
            sum-=candidates[i];
        }
    }






    /*无重可复选，排列
    *
    * */
    public List<List<Integer>> permuteRepeat(int[] nums) {
        backtrack(nums);
        return res;
    }

    // 回溯算法核心函数
    void backtrack(int[] nums) {
        // base case，到达叶子节点
        if (track.size() == nums.length) {
            // 收集叶子节点上的值
            res.add(new LinkedList(track));
            return;
        }

        // 回溯算法标准框架
        for (int i = 0; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 进入下一层回溯树
            backtrack(nums);
            // 取消选择
            track.removeLast();
        }
    }
}
