package com.dongyin.leetcode;

/**
 * @author dystart
 * @create 2022-04-04 16:01
 */
public class SumArray {

}
class NumArray {

    int[] perSum;

    public NumArray(int[] nums) {
        perSum=new int[nums.length+1];
        for (int i = 0; i < perSum.length-1; i++) {
            perSum[i+1]=perSum[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return perSum[right+1]-perSum[left];
    }
}
class NumMatrix {

    public NumMatrix(int[][] matrix) {

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 0;
    }
}
