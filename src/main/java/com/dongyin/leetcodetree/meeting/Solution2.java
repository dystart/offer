package com.dongyin.leetcodetree.meeting;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**一个方法解决三道区间问题\
 * 起点升序排列，终点降序
 * @author dystart
 * @create 2022-04-14 17:24
 */
public class Solution2 {

    //遍历每一个区间如果被覆盖则+1记录
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length==0)return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    //终点降序
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        int left=intervals[0][0];
        int right=intervals[0][1];
        int res=0;
        for (int i = 1; i < intervals.length; i++) {
            if (left<=intervals[i][0]&&right>=intervals[i][1]){
                res++;
                continue;
            }
            if (right<=intervals[i][0]){
                left=intervals[i][0];
                right=intervals[i][1];
            }
            if (right<=intervals[i][1]&&left<=intervals[i][0]){
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        return intervals.length-res;
    }


    public static void main(String[] args) {
        int[][] ints={{1,3},{2,6},{8,10},{15,18}};
        merge(ints);
    }

    //去除重叠区间
    public static int[][] merge(int[][] intervals) {
        if (intervals.length==0)return null;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        int left=intervals[0][0];
        int right=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            //当前right<下一关终点,需要合并
            if (right<interval[0]){
                //合并
                int[] ints = {left, right};
                res.add(ints);
                left=interval[0];
                right=interval[1];
                continue;
            }
            if (right>=interval[0]&&right<interval[1]){
                right=interval[1];
            }
        }
        int[] ints = {left, right};
        res.add(ints);
        int[][] resZ = new int[res.size()][2];
        for (int i = 0; i < resZ.length; i++) {
            resZ[i]=res.removeLast();
        }
        return resZ;
    }




    //两个集合的交集
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        return null;
        //把两个集合合成以一个求交集
    }

    //求两个集合的交集
    public int[] intervalInter(int[] first,int[] second){return null;
    }
}
