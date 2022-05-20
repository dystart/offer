package com.dongyin.leetcodetree.meeting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**分治算法详解：运算优先级
 * @author dystart
 * @create 2022-04-13 18:56
 */
public class Solution {

    //分治模板
//    void sort(int[] nums, int lo, int hi) {
//        int mid = (lo + hi) / 2;
//        /****** 分 ******/
//        // 对数组的两部分分别排序
//        sort(nums, lo, mid);
//        sort(nums, mid + 1, hi);
//        /****** 治 ******/
//        // 合并两个排好序的子数组
//        merge(nums, lo, mid, hi);
//    }


    //备忘录
    Map<String,List<Integer>> memo=new HashMap();
    //给你一个由数字和运算符组成的字符串 expression ，
    // 按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)){
            return memo.get(expression);
        }
        if (expression.length()==0)return null;
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c=='+'||c=='-'||c=='*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer left1 : left) {
                    for (Integer rig : right) {
                        if (c=='+'){
                            res.add(left1+rig);
                        }
                        if (c=='-'){
                            res.add(left1-rig);
                        }
                        if (c=='*'){
                            res.add(left1*rig);
                        }
                    }
                }
            }
        }
        // base case递归函数必须有个 base case 用来结束递归
        // 如果 res 为空，说明算式是一个数字，没有运算符
        if (res.size()==0){
            res.add(Integer.parseInt(expression));
        }
        memo.put(expression,res);
        return res;
    }
}
