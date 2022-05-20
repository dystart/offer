package com.dongyin.leetcodetree.dongtaiguihua;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 动态规划的核心设计思想是数学归纳法。
 * 那么我们先假设这个结论在 k < n 时成立，然后根据这个假设，
 * 想办法推导证明出 k = n 的时候此结论也成立。
 * 如果能够证明出来，那么就说明这个结论对于 k 等于任何数都成立。
 * 我们可以假设 dp[0...i-1] 都已经被算出来了，然后问自己：怎么通过这些结果算出 dp[i]？
 */
public class Solution2 {


//    我们的定义是这样的：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    //dp[i+1]==num[i+1]前面比自己小的数的最长递增子序列的长度+1
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length+1];
        //base
        dp[0]=1;
        for (int i = 0; i < dp.length-1; i++) {
            //j是之前的
            int res=0;
            for (int j = 0; j<i; j++) {
                if (nums[j]<nums[i]){
                    res=Math.max(res,dp[j]);
                }
            }
            dp[i]=Math.max(dp[i],res+1);
        }
        //最大值
        int max=0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]>max){
              max=dp[i];
            }
        }
        return max;
    }


//    给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，
//    表示第 i 个信封的宽度和高度。
//
//    当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，
//    如同俄罗斯套娃一样。

    public int maxEnvelopes(int[][] envelopes) {
        //如果把长进行排序，那么宽的最长子序列就是信封长度
        //从小到大
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ?
                        o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        //base
        int[] length = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            length[i]=envelopes[i][1];
        }
        return lengthOfLIS(length);
    }

}
