package com.dongyin.jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dystart
 * @create 2022-04-22 23:58
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.addBinary( "0","0"));
//        byte b='a';
//        System.out.println(b);
//        byte[] bytes1={'s','a','c'};
//        Arrays.sort(bytes1);
//        for (int i = 0; i < bytes1.length; i++) {
//            System.out.println(bytes1[i]);
//        }
        String[] strings={"abcw","abcdef","baz","foo","bar","xtfn","abcdef"};
        System.out.println(solution.isCoint("xtfn", "abcdef"));
        System.out.println(solution.maxProduct(strings));
    }

    //1,减法
    public int divide(int a, int b) {
        int res=0;
        // 考虑被除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
            if (b>0){
                a+=b;
                res+=1;
            }
            if (b<0){
                a+=-b;
                res+=1;
            }
        }
        // 考虑除数为最小值的情况

        // 考虑被除数为 0 的情况
        if (a == 0) {
            return 0;
        }

        //true==-
        boolean flag=true;
        if (a<0&&b>0||a>0&&b<0){
            flag=false;
        }
        a=Math.abs(a);
        b=Math.abs(b);
        while (true){
            if(a<b){
                break;
            }
            a=a-b;
            res++;
        }
        if (flag) {
            return res;
        }else {
            return -res;
        }
    }



    //2,栈来存放两个字符串
    public String addBinary1(String a, String b) {
        int a1=Integer.parseInt(a);
        int b1=Integer.parseInt(b);
        int resa=-1,resb=-1;
        int jinWei=0;
        String res="";
        if (a1==0&&b1==0){
            return "0";
        }
        while (a1!=0||b1!=0||jinWei!=0){
            resa=a1%10;
            resb=b1%10;
            if (resa+resb+jinWei<2){
                res=(resa+resb+jinWei)+res;
                jinWei=0;
            }else {
                int temp=jinWei;
                jinWei=1;
                res=(resa+resb+temp-2)+res;
            }
            a1=a1/10;
            b1=b1/10;
        }
        return res;
    }

    //2
    public String addBinary(String a, String b) {
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        int resa=-1,resb=-1;
        int jinWei=0;
        String res="";
        int i=charsa.length-1,j=charsb.length-1;
        int a1=-1,b1=-1;
        while (i>=0||j>=0||jinWei>0){
            if (i>=0) {
                a1 = Integer.parseInt(String.valueOf(charsa[i--]));
            }else {
                a1=0;
            }
            //System.out.println(a1);
            if (j>=0) {
                b1 = Integer.parseInt(String.valueOf(charsb[j--]));
            }else {
                b1=0;
            }
            //System.out.println(b1);
            if (a1+b1+jinWei<2){
                res=(a1+b1+jinWei)+res;
                //System.out.println(res);
                jinWei=0;
            }else {
                int temp=jinWei;
                jinWei=1;
                res=(a1+b1+temp-2)+res;
            }
        }
        return res;
    }


    //3
    public int[] countBits(int n) {
        int[] ints = new int[n+1];
        int yuShu=0,xianShu=0,res=0;
        for (int i = 0; i <= n; i++) {
            xianShu=i;
            //xianShu是被除数
            while (xianShu>=1){
                yuShu=xianShu%2;
                xianShu=xianShu/2;
                if (yuShu==1){
                    res++;
                }
            }
            ints[i]=res;
            res=0;
        }
        return ints;
    }


    //4，排序
    public int singleNumber(int[] nums) {
        if (nums.length==1)return nums[0];
        Arrays.sort(nums);
        if (nums[0]!=nums[1]){
            return nums[0];
        }
        if (nums[nums.length-1]!=nums[nums.length-2]){
            return nums[nums.length-1];
        }

        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }


    //5，字符串排序
    public int maxProduct(String[] words) {
        back(words,0);
        return max;
    }
    int max=0;
    void back(String[] words,int n){
        if (n==words.length){
            return ;
        }
        for (int i = n; i < words.length-1; i++) {
            if (!isCoint(words[n],words[i+1])) {
                max = Math.max(max, words[n].length()*words[i+1].length());
            }
        }
        back(words,n+1);
    }

    public boolean isCoint(String s1,String s2){
        byte[] bytes1 = s1.getBytes();
        byte[] bytes2 = s2.getBytes();
        Arrays.sort(bytes1);
        Arrays.sort(bytes2);
        int i=0,j=0;
        while (i<s1.length()&&j<s2.length()){
            if(bytes1[i]==bytes2[j]){
                return true;
            }
            if(bytes1[i]>bytes2[j]){
                j++;
            }else {
                i++;
            }
        }
        return false;
    }
}
