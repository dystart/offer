package com.dongyin.jianzhioffer;

/**
 * @author dystart
 * @create 2022-04-23 15:27
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("ddwcwdd"));
    }
    //18
    public static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        int left=0,right=s1.length()-1;
        while (left<right){
            if (!(s1.charAt(left)<='z'&&s1.charAt(left)>='a'||
                    s1.charAt(left)<='9'&&s1.charAt(left)>='0')){
                left++;
                continue;
            }
            if (!(s1.charAt(right)<='z'&&s1.charAt(right)>='a'||
                    s1.charAt(right)<='9'&&s1.charAt(right)>='0')){
                right--;
                continue;
            }
            if (s1.charAt(left)!=s1.charAt(right)){
                return false;
            }
            left++;right--;
        }
        return true;
    }




    //19
    public static boolean validPalindrome(String s) {
        int low=0,high=s.length()-1;
        while (low<high){
            if (s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }else {
                return isHuiwen(s,low+1,high)||isHuiwen(s,low,high-1);
            }
        }
        return true;
    }

    static boolean isHuiwen(String s,int low,int high){
        int left=low,right=high;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;right--;
        }
        return true;
    }
}
