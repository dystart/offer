package com.dongyin.jianzhioffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dystart
 * @create 2022-04-23 9:15
 */
public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {
        //双指针
        int left = 0, right = numbers.length - 1;
        while (left < right && left >= 0 && right <= numbers.length - 1) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left, right};
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }
        return null;
    }


    //元素可重不复选,排序
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        back(nums, 0);
        return res;
    }


    void back(int[] nums, int n) {
        if (track.size() == 3 && track.get(0) + track.get(1) + track.get(2) == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = n; i < nums.length; i++) {
            if (i > n && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            back(nums, i + 1);
            track.removeLast();
        }
    }


    //8
    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target) return 1;
        int left = 0, right = 1, res = nums[0], min = Integer.MAX_VALUE;
        while (left < right) {
            if (res >= target) {
                min = Math.min(min, right - left);
                res -= nums[left];
                left++;
            }
            if (right >= nums.length && res < target) {
                break;
            }
            if (res < target) {
                res += nums[right++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    //9
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, result = 1;
        int ans = 0;
        while (left < n && left <= right) {
            while (right < n && result * nums[right] < k) {
                result *= nums[right];
                right++;
            }
            ans += right - left;
            result /= nums[left];
            left++;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {2,1,-1};
        System.out.println(solution2.pivotIndex(nums));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public int pivotIndex(int[] nums) {
        int[] ints = new int[nums.length+1];
        ints[0]=0;
        for (int i = 1; i < ints.length; i++) {
            ints[i]=ints[i-1]+nums[i-1];
        }
        int sum=ints[ints.length-1];
        for (int i = 1; i < ints.length; i++) {
           if (ints[i-1]==sum-ints[i]){
               return i;
           }
        }
        if (sum-ints[1]==0)return 0;
        return -1;
    }
}
