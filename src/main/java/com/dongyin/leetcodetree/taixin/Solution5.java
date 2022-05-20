package com.dongyin.leetcodetree.taixin;

import java.util.Arrays;

/**跳跃游戏
 * @author dystart
 * @create 2022-04-11 10:52
 */
public class Solution5 {
    //I
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int fastJump=0;
        for (int i = 0; i < length - 1; i++) {
            //i为当前位置，nums[i]表示当前位置可以跳的最大值
            fastJump=Math.max(fastJump,i+nums[i]);
            //遇到0,跳不动,在i之前无论如何都无法找过i
            if (fastJump<=i){
                return false;
            }
        }
        //跳length-1即可到达
        return fastJump>=length-1;
    }



    //II动态规划
    int[] mone;//备忘录，用来存放，mone[i]为从第i位置开始最少走几步
    public int jump(int[] nums) {
        int n = nums.length;
        mone=new int[n];
        //最多跳n-1步，所以初始化为最大
        Arrays.fill(mone,n);
        return dp(nums,0);
    }

    //从p开始跳
    public int dp(int[] nums,int p){
        //最多跳length-1即可到达
        if (p>=nums.length-1){
            return 0;
        }
        //子问题解决
        if (mone[p]!=nums.length){
            return mone[p];
        }
        //这一步最多可以跳step次
        int step=nums[p];
        for (int i = 1; i <= step; i++) {
            //子问题，跳i次，呢么下一次子问题p=p+i;
            int subProblem = dp(nums, p+i);
            //最小步数为子问题的最小+1
            mone[p]=Math.min(mone[p],subProblem+1);
        }
        return mone[p];
    }






}
