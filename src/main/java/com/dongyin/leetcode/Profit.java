package com.dongyin.leetcode;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * @author dystart
 * @create 2022-04-03 14:49
 */
public class Profit {

    public int maxProfit2(int[] prices) {
        //0,1,prices.length天数
        int[][] ints = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i-1==-1){
                ints[0][0]=0;
                ints[0][1]=-prices[i];
                continue;
            }
            ints[i][0]=Math.max(ints[i-1][0],ints[i-1][1]+prices[i]);
            ints[i][1]=Math.max(ints[i-1][1],-prices[i]);
        }
        return ints[prices.length-1][0];
    }



    public int maxProfit1(int[] prices) {
        int[][] ints = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i-1==-1){
                ints[0][0]=0;
                ints[0][1]=Integer.MIN_VALUE;
                continue;
            }
            ints[i][0]=Math.max(ints[i-1][0],ints[i-1][1]+prices[i]);
            ints[i][1]=Math.max(ints[i-1][1],ints[i-1][0]-prices[i]);
        }
        return ints[prices.length-1][0];
    }



    public int maxProfit3(int[] prices) {
        int[][] pric = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i-1==-1){
                pric[0][0]=0;
                pric[0][1]=-prices[0];
                continue;
            }
            if(i==1){
                pric[i][0]=Math.max(pric[i-1][0],pric[i-1][1]+prices[i]);
                pric[i][1]=Math.max(pric[i-1][1],-prices[i]);
                continue;
            }
            pric[i][0]=Math.max(pric[i-1][0],pric[i-1][1]+prices[i]);
            pric[i][1]=Math.max(pric[i-1][1],pric[i-2][0]-prices[i]);
        }
        return pric[prices.length-1][0];
    }





    public int maxProfit5(int[] prices, int fee) {
        int[][] ints = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i-1==-1){
                ints[0][0]=0;
                ints[0][1]=-prices[0]-fee;
                continue;
            }
            ints[i][0]=Math.max(ints[i-1][0],ints[i-1][1]+prices[i]);
            ints[i][1]=Math.max(ints[i-1][1],ints[i-1][0]-prices[i]-fee);
        }
        return ints[prices.length-1][0];
    }


    public int maxProfit6(int[] prices) {
        int k_max=2;
        int[][][] ints = new int[prices.length][k_max+1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = k_max;k>=1; k--) {
                if (i - 1 == -1) {
                    ints[0][k][0] = 0;
                    ints[0][k][1] = -prices[i];
                    continue;
                }
                ints[i][k][0] = Math.max(ints[i - 1][k][0], ints[i - 1][k][1] + prices[i]);
                ints[i][k][1] = Math.max(ints[i - 1][k][1], ints[i - 1][k - 1][0] - prices[i]);
            }
        }
        return ints[prices.length-1][k_max][0];
    }






    public int maxProfit_k_inf(int[] prices) {
        int[][] ints = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i-1==-1){
                ints[0][0]=0;
                ints[0][1]=-prices[i];
                continue;
            }
            ints[i][0]=Math.max(ints[i-1][0],ints[i-1][1]+prices[i]);
            ints[i][1]=Math.max(ints[i-1][1],ints[i-1][0]-prices[i]);
        }
        return ints[prices.length-1][0];
    }
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        if (k > prices.length / 2) {
            // 复用之前交易次数 k 没有限制的情况
            return maxProfit_k_inf(prices);
        }
        int[][][] ints = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            ints[i][0][1] = Integer.MIN_VALUE;
            ints[i][0][0] = 0;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j>=1; j--) {
                if (i- 1==-1){
                    ints[0][j][0]=0;
                    ints[0][j][1]=-prices[i];
                    continue;
                }
                ints[i][j][0]=Math.max(ints[i-1][j][0],ints[i-1][j][1]+prices[i]);
                ints[i][j][1]=Math.max(ints[i-1][j][1],ints[i-1][j-1][0]-prices[i]);
            }
        }
        return ints[prices.length-1][k][0];
    }










    int maxProfit_k_inf(int[] prices, int cooldown, int fee){
        int[][] ints = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if(i-1==-1){
                ints[0][0]=0;
                ints[0][1]=-prices[i]-fee;
                continue;
            }
            if (i<cooldown+1){
                ints[i][0]=Math.max(ints[i-1][0],ints[i-1][1]+prices[i]);
                ints[i][1]=Math.max(ints[i-1][1],-prices[i]-fee);
                continue;
            }
            ints[i][0]=Math.max(ints[i-1][0],ints[i-1][1]+prices[i]);
            ints[i][1]=Math.max(ints[i-1][1],ints[i-cooldown-1][0]-prices[i]-fee);
        }
        return ints[prices.length-1][0];
    }


    int maxProfit_all_in_one(int max_k, int[] prices, int cooldown, int fee){
        if (prices.length==0){
            return 0;
        }
        if (max_k>prices.length/2){
            return maxProfit_k_inf(prices,cooldown,fee);
        }
        int[][][] ints = new int[prices.length][max_k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            ints[i][0][0]=0;
            ints[i][0][1]=-prices[i]-fee;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int k = max_k; k>=1; k--) {
                if (i-1==-1){
                    ints[0][k][0]=0;
                    ints[0][k][1]=-prices[i]-fee;
                }
                if(i<cooldown+1){
                    ints[i][k][0]=Math.max(ints[i-1][k][0],ints[i-1][k][1]+prices[i]);
                    ints[i][k][1]=Math.max(ints[i-1][k][1],-prices[i]-fee);
                }
                ints[i][k][0]=Math.max(ints[i-1][k][0],ints[i-1][k][1]+prices[i]);
                ints[i][k][1]=Math.max(ints[i-1][k][1],ints[i-cooldown-1][k-1][0]-prices[i]-fee);
            }
        }
        return ints[prices.length-1][max_k][0];
    }
}
