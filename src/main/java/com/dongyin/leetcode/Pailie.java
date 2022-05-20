package com.dongyin.leetcode;

import org.redisson.api.annotation.RIndex;
import org.springframework.boot.web.embedded.netty.NettyWebServer;

import java.util.*;

/**
 * @author dystart
 * @create 2022-03-31 23:29
 */
public class Pailie {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();
    // 记录 track 中的元素之和
    //全排列
    boolean used[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backUnique(nums);
        return res;
    }

    void backUnique(int[] nums){
        if (track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i-1]==nums[i]&&!used[i-1]){
                continue;
            }
            if (used[i]) {
                continue;
            }else {
                track.addLast(nums[i]);
                used[i] =true;
            }
            backUnique(nums);
            track.removeLast();
            used[i]=false;
        }
    }



    //无重复，可无限使用
    List<List<Integer>> resSum = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> trackSum = new LinkedList<>();
    // 记录 track 中的元素之和
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backCombination(candidates,target,0);
        return resSum;
    }

    void backCombination(int[] candidates,int target,int start){
        if (sum==target){
            resSum.add(new LinkedList<>(trackSum));
            return;
        }
        if (sum>target){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            trackSum.addLast(candidates[i]);
            sum+=candidates[i];
            backCombination(candidates,target,i);
            trackSum.removeLast();
            sum-=candidates[i];
        }
    }




    //[-1,0,3,5,9,12]
    //2
    public int search(int[] nums, int target) {
        int left =0,right=nums.length;
        while (left<=right){
            int mid= left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else if (nums[mid]>target){
                right=mid-1;
            }
        }
        return -1;
    }



    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target) {



            return -1;
        }
        return left;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target) {



            return -1;
        }
        return right;
    }
    public int[] searchRange(int[] nums, int target) {
        int left_bound = left_bound(nums, target);
        int right_bound = right_bound(nums, target);
        return new int[]{left_bound,right_bound};
    }




    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        int left = 0,right=0;
        //needs中每一种字符
        int valid = 0;
        //字串起始与长度
        int start=0,len=Integer.MAX_VALUE;
        char[] chars = t.toCharArray();
        char[] Schars = s.toCharArray();
        for (char aChar : chars) {
            //need放入，没有默认0+1，有取出加一
            need.put(aChar,need.getOrDefault(aChar,0)+1);
        }
        while (right<Schars.length){
            char schar = Schars[right];
            right++;
            if (need.containsKey(schar)) {
                windows.put(schar, windows.getOrDefault(schar, 0) + 1);
                if (windows.get(schar).equals(need.get(schar))) {
                    valid++;
                }
            }
            while (valid==need.size()){
                if (right-left<len){
                    start=left;
                    len=right-left;
                }
                char schar1 = Schars[left];
                left++;
                if (windows.containsKey(schar1)){
                    if (windows.get(schar1).equals(need.get(schar1))){
                        valid--;
                    }
                    windows.put(schar1,windows.getOrDefault(schar1,0)-1);
                }
            }
        }
        if (len!=Integer.MAX_VALUE) {
            return s.substring(start, start + len);
        }else {
            return "";
        }
    }


    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        int left = 0,right=0;
        //needs中每一种字符
        int valid = 0;
        char[] chars = s1.toCharArray();
        char[] Schars = s2.toCharArray();
        for (char aChar : chars) {
            //need放入，没有默认0+1，有取出加一
            need.put(aChar,need.getOrDefault(aChar,0)+1);
        }
        while (right<Schars.length){
            char schar = Schars[right];
            right++;
            if (need.containsKey(schar)) {
                windows.put(schar, windows.getOrDefault(schar, 0) + 1);
                if (windows.get(schar).equals(need.get(schar))) {
                    valid++;
                }
            }
            //字符一样长
            while (right-left==s1.length()){
                //并且都有
                if (valid==need.size()){
                    return true;
                }
                char schar1 = Schars[left];
                left++;
                if (need.containsKey(schar1)){
                    if (windows.get(schar1).equals(need.get(schar1))){
                        valid--;
                    }
                    windows.put(schar1,windows.getOrDefault(schar1,0)-1);
                }
            }
        }
        return false;
    }





    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        int left = 0,right=0;
        //needs中每一种字符
        int valid = 0;
        char[] chars = p.toCharArray();
        char[] Schars = s.toCharArray();
        for (char aChar : chars) {
            //need放入，没有默认0+1，有取出加一
            need.put(aChar,need.getOrDefault(aChar,0)+1);
        }
        while (right<Schars.length){
            char schar = Schars[right];
            right++;
            if (need.containsKey(schar)) {
                windows.put(schar, windows.getOrDefault(schar, 0) + 1);
                if (windows.get(schar).equals(need.get(schar))) {
                    valid++;
                }
            }
            //字符一样长
            while (right-left==p.length()){
                //并且都有
                if (valid==need.size()){
                    res.add(left);
                }
                char schar1 = Schars[left];
                left++;
                if (need.containsKey(schar1)){
                    if (windows.get(schar1).equals(need.get(schar1))){
                        valid--;
                    }
                    windows.put(schar1,windows.getOrDefault(schar1,0)-1);
                }
            }
        }
        return res;
    }



    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left=0,right=0;
        char[] chars = s.toCharArray();
        int res=0;
        while (right<s.length()){
            char aChar = chars[right];
            right++;
            window.put(aChar,window.getOrDefault(aChar,0)+1);
            while (window.get(aChar)>1){
                char aChar1 = chars[left];
                left++;
                window.put(aChar1,window.getOrDefault(aChar1,0)-1);
            }
            res=Math.max(res, right-left);
        }
        return res;
    }
}
