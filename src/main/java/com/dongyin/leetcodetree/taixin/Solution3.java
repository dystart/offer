package com.dongyin.leetcodetree.taixin;

/**前缀和数组
 * @author dystart
 * @create 2022-04-10 20:14
 */
public class Solution3 {

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        //前缀数组
        int[] perSum = new int[length + 1];
        for (int i = 1; i < perSum.length; i++) {
            perSum[i]=perSum[i-1]+nums[i-1];
        }
        int res=0;
        for (int i = 1; i < perSum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (perSum[i]-perSum[j]==k){
                    res++;
                }
            }
        }
        return res;
    }
}

class NumMatrix {

    //前缀数组，preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int n=matrix.length+1,m=matrix[0].length+1;
        if (n==0||m==0)return;
        preSum =new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                preSum[i][j]=preSum[i-1][j]+preSum[i][j-1]+matrix[i-1][j-1]-preSum[i-1][j-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1]-preSum[row2+1][col1]-preSum[row1][col2+1]+preSum[row1][col1];
    }
}

//前缀数组，数组i存放的是i之前的所有元素之和
class NumArray {

    int[] perArr;
    public NumArray(int[] nums) {
        perArr=new int[nums.length+1];
        for (int i = 1; i < perArr.length; i++) {
            perArr[i]=perArr[i-1]+nums[i-1];
        }
    }

    //perArr[i]中的值是nums前i-1的和
    public int sumRange(int left, int right) {
        return perArr[right+1]-perArr[left];
    }
}
