package com.dongyin.jianzhioffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author dystart
 * @create 2022-05-10 12:27
 */
public class Solution3 {




    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                left++;
            } else if (nums[right] % 2 == 0) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        //两个指针，第一个到k的时候第二个开始，第一个到达终点时，第二个就是倒数第k
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    public static int majorityElement(int[] nums) {
        //出现最多的次数
        int max = 0, flag = 1;
        //出现最多次数的数
        int maxNum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                flag++;
            }else {
                if (flag > max) {
                    max = flag;
                    maxNum = nums[i];
                    flag = 1;
                }
            }
        }
        if (flag > max) {
            max = flag;
            maxNum = nums[nums.length-1];
        }
        if (max > nums.length / 2) {
            return maxNum;
        }
        return -1;
    }



    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=arr[i];
        }
        return ints;
    }





    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }







    public static char firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);
            //首次出现的位置是当前位置，且后面没有再出现这个字符
            if (s.indexOf(at)==i&&s.indexOf(at,i+1)==-1){
                return at;
            }
        }
        return ' ';
    }




    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }



    //排序好的
    public int[] twoSum(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<right){
            if (nums[left]+nums[right]==target){
                return new int[]{nums[left],nums[right]};
            }else if (nums[left]+nums[right]<target){
                left++;
            }else {
                right--;
            }
        }
        return null;
    }




    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        String res="";
        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals("")) {
                res = s1[i] + " " + res;
            }
        }
        return res.trim();
    }

    public static void main(String[] args) {
        int[] ints = {0, 0, 1,2,5};
        System.out.println(isStraight(ints));
    }




    //1到13是不是顺子，大小王任意牌
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero=0,number=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                zero++;
            }
        }
        for (int i = zero+1; i < nums.length; i++) {
            if (nums[i]==nums[i-1])return false;
            number+=nums[i]-nums[i-1]-1;
        }
        if (number>zero){
            return false;
        }else {
            return true;
        }
    }





    public String reverseLeftWords(String s, int n) {
        String substring = s.substring(0, n);
        String res=s+substring;
        return res.substring(n);
        //return (s+s.substring(0, n)).substring(n);
    }


    public int lastRemaining(int n, int m) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(i);
        }
        //里面有n个元素
        int div=0;//需要删除的元素的下标
        while (n>1){
            div=(div+m-1)%n;
            integers.remove(div);
            n--;
        }
        return integers.get(0);
    }








    public int search(int[] nums, int target) {
        int left =0,right = nums.length-1;
        int count = 0;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target)
                right=mid;
            if(nums[mid]<target)
                left = mid+1;
        }
        //大于left
        while(left<nums.length&&nums[left++]==target)
            count++;
        return count;
    }



    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}





class MinStack {
    public Stack<Integer> stack;
    int min=Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(min);
        if (x<min)min=x;
        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        min=stack.pop();
    }

    public int top() {
        Integer pop = stack.pop();
        stack.push(pop);
        return pop;
    }

    public int min() {
        return min;
    }
}
