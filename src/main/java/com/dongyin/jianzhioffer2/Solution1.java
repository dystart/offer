package com.dongyin.jianzhioffer2;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author dystart
 * @create 2022-05-09 20:14
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution1 {


    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]==nums[i]){
                return nums[i];
            }
        }
        return -1;
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }
        //从左上角开始判断
        int i=0,j=0,hang=matrix.length,lie=matrix[0].length;
        while (i<hang&&j<lie){
            if (target==matrix[i][j]){
                return true;
            }
            if (target>matrix[i][j]){
                if (i+1==hang) {
                    j++;
                    continue;
                }
                if (j+1==lie){
                    i++;
                    continue;
                }
                if (i+1!=hang&&j+1!=lie){
                    i++;
                    j++;
                    continue;
                }
            }
            if (target<matrix[i][j]){
                for (int k1=0;k1<i;k1++){
                    if (matrix[k1][j]==target){
                        return true;
                    }
                }
                for (int k2=0;k2<j;k2++){
                    if (matrix[i][k2]==target){
                        return true;
                    }
                }
                if (i+1==hang) {
                    j++;
                    continue;
                }
                if (j+1==lie){
                    i++;
                    continue;
                }
                if (i+1!=hang&&j+1!=lie){
                    i++;
                    j++;
                    continue;
                }
            }
        }
        return false;
    }





    public String replaceSpace(String s) {
        String s1="";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                s1+="%20";
            }else {
                s1+=s.charAt(i);
            }
        }
        return s1;
    }








    public int[] reversePrint(ListNode head) {
        Stack<Integer> integers = new Stack<>();
        while (head!=null){
            integers.push(head.val);
            head=head.next;
        }
        int[] ints = new int[integers.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=integers.pop();
        }
        return ints;
    }






}
