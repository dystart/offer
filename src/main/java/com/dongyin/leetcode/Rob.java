package com.dongyin.leetcode;

import java.util.Arrays;

/**
 * @author dystart
 * @create 2022-04-03 18:23
 */
public class Rob {

//    int[] mone;
//    public int rob1(int[] nums) {
//        mone=new int[nums.length];
//        Arrays.fill(mone,-1);
//        return dp(nums,0);
//    }
//
//    public int dp1(int[] nums,int start){
//        int res=0;
//        if (start>=nums.length){
//            return 0;
//        }
//        if(mone[start]!=-1)return mone[start];
//        res=Math.max(dp(nums,start+1),nums[start]+dp(nums,start+2));
//        mone[start]=res;
//        return res;
//    }


    int[] mone;//[1,2,3]
    public int rob(int[] nums) {
        int length = nums.length;
        if (length==1){
            return nums[0];
        }
        mone=new int[nums.length];
        Arrays.fill(mone,-1);
        int dp = dp(nums, 0, length-1);
        mone=new int[nums.length];
        Arrays.fill(mone,-1);
        return Math.max(dp,dp(nums,1,length));
    }

    public int dp(int[] nums,int start,int end){
        int res=0;
        if (start>=end){
            return 0;
        }
        if(mone[start]!=-1)return mone[start];
        res=Math.max(dp(nums,start+1,end),nums[start]+dp(nums,start+2,end));
        mone[start]=res;
        return res;
    }
}
