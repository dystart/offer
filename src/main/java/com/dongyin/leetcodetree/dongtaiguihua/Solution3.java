package com.dongyin.leetcodetree.dongtaiguihua;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 重叠子问题：像二位数组，到下一个节点的路径不只一条
 * dp数组大小和遍历方向
 * 遍历的过程中，所需的状态必须是已经计算出来的。
 */
public class Solution3 {
    public static void main(String[] args) {
    }

    //给你一个 n x n 的 方形 整数数组 matrix ，
    // 请你找出并返回通过 matrix 的下降路径 的 最小和 。
    //每次下降，可以向下、向左下、向右下三个方向移动一格。
    public int minFallingPathSum(int[][] matrix) {
        dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(dp[i], 66666);
        }

        int min=Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; j++) {
            min=Math.min(min,dp(matrix,matrix.length-1,j));
        }
        return min;
    }

    int[][] dp;
    //对于 matrix[i][j]，只有可能从 matrix[i-1][j],
    // matrix[i-1][j-1], matrix[i-1][j+1] 这三个位置转移过来。
    int dp(int[][] matrix,int i,int j){
        //非法索引
        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length){
            return 99999;
        }
        // 2、base case
        if (i == 0) {
            return matrix[0][j];
        }
        if (dp[i][j] != 66666) {
            return dp[i][j];
        }
        dp[i][j]= matrix[i][j]+min(dp(matrix,i-1,j),dp(matrix,i-1,j-1),dp(matrix,i-1,j+1));
        return dp[i][j];
    }

    int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}
