package com.dongyin.leetcodetree.dongtaiguihua;

import java.util.Arrays;

/**算法是穷举，动态规划就是每一个穷尽都还是找到最优解，求最值是典型
 * 基本步骤：明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义。
 * # 初始化 base case
 * dp[0][0][...] = base
 * # 进行状态转移
 * for 状态1 in 状态1的所有取值：
 *     for 状态2 in 状态2的所有取值：
 *         for ...
 *             dp[状态1][状态2][...] = 求最值(选择1，选择2...)\
 *           动态规划不就是从最简单的 base case 往后推导吗，可以想象成一个链式反应，以小博大
 */
public class Solution1 {

    //斐波那契数列，后一项是前两项的和，输出第n项
    public int fib(int n) {
        //优化，备忘录
        int[] memo=new int[n+1];
        return helper(n,memo);
    }

    int helper(int n,int[] ints){
        if(n==0||n==1){
            return n;
        }
        if (ints[n]!=0){
            return ints[n];
        }
        ints[n]= helper(n-1,ints)+helper(n-2,ints);
        return ints[n];
    }

    //按照模板
    int fub(int n){
        if (n==0)return 0;
        int[] ints = new int[n + 1];
        //base
        ints[0]=0;ints[1]=1;
        for (int i = 2; i < n+1; i++) {
            ints[i]=ints[i-1]+ints[i-2];
        }
        return ints[n];
    }



    //按模板凑零钱问题
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        if (amount<0)return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;//表示存0元需要0个硬币 base
        //i表示凑i元钱
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i-coin<0){
                    continue;
                }
                //1+dp[i-coin]是这个硬币加上减掉这个硬币需要的个数
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

}
