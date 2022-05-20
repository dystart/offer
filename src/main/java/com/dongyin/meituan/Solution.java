package com.dongyin.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author dystart
 * @create 2022-04-09 15:57
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static int solution(int n){
        int res=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);
        map.put(4,0);
        map.put(5,0);
        map.put(6,1);
        map.put(7,0);
        map.put(8,2);
        map.put(9,1);
        while (n>0){
            int temp=n%10;
            res+=map.get(temp);
            n=n/10;
        }
        return res;
    }

    public Solution(int n){
    }




}
