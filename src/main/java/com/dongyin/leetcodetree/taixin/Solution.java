package com.dongyin.leetcodetree.taixin;

import java.util.Arrays;
import java.util.Comparator;

/**区间调度
 * 比如你面前放着 100 张人民币，你只能拿十张，怎么才能拿最多的面额？
 * 显然每次选择剩下钞票中面值最大的一张，最后你的选择一定是最优的。
 * 每一次都是局部最优，最后则是全局最优
 * @author dystart
 * @create 2022-04-10 14:02
 */
public class Solution {

    public static void main(String[] args) {
        int[][] ints=new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(eraseOverlapIntervals(ints));
        System.out.println(Integer.MIN_VALUE);
    }

    //间隔规划
    public static int intervalSchedule(int[][] ints){
        if (ints.length==0)return 0;
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return 1;
                if (o1[1] < o2[1]) return -1;
                return 0;
            }
        });

        int count=1;
        int x_end=ints[0][1];
        for (int[] anInt : ints) {
            if (anInt[0]>=x_end){
                count++;
                x_end=anInt[1];
            }
        }
        return count;
    }



    //最小移动区间
    public static int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length-intervalSchedule(intervals);
    }







    //扎气球
    public int findMinArrowShots(int[][] points) {
        return intervalSchedule(points);
    }
}
