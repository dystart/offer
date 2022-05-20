package com.dongyin.leetcode;

/**
 * @author dystart
 * @create 2022-03-30 21:24
 */
public class ArraySolution {

    public int removeDuplicates(int[] nums) {
        if (nums.length==0)return 0;
        int slow=0,fast=1;
        while (fast<nums.length){
            if (nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }


    public int removeElement(int[] nums, int val) {
        if (nums.length==0)return 0;
        int fast=0,slow=0;
        while (fast<nums.length){
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public void moveZeroes(int[] nums) {
        int fast = 0,slow=0;
        while (fast<nums.length){
            if (nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = nums.length-(fast-slow); i < nums.length; i++) {
            nums[i]=0;
        }
    }


    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while (left<right){
            if (numbers[left]+numbers[right]==target){
                return new int[]{left+1,right+1};
            }
            else if (numbers[left]+numbers[right]<target){
                left++;
            }else if (numbers[left]+numbers[right]>target){
                right--;
            }
        }
        return null;
    }


    public void reverseString(char[] s) {
        int left =0,right=s.length-1;
        while (left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }


    public String longestPalindrome(String s) {
        int l=0,r=0;
        String maxString = "";
        while (l<s.length()){
            String palindrome = palindrome(s, l, r);
            if (palindrome.length()>maxString.length()){
                maxString=palindrome;
            }
            if (l<r){
                l++;
            }else {
                r++;
            }
        }
        return maxString;
    }


    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    String palindrome(String s, int l, int r) {
        while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        //[l+1,r)
        return s.substring(l+1,r);
    }



    //判断是否为回文串
    public  boolean isHuiWen(String s){
        char[] chars = s.toCharArray();
        int left =0,right=chars.length-1;
        while (left<right){
            if (chars[left]!=chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
