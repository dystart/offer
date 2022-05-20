package com.dongyin.leetcodetree.taixin;

import java.lang.reflect.Array;
import java.util.Arrays;

/**会议申请，同一时刻有多少会议执行
 * @author dystart
 * @create 2022-04-10 15:06
 */
public class Solution1 {

    //同一时刻最大的会议
    int minMeetingRooms(int[][] meetings){
        if (meetings.length==0){
            return 0;
        }
        int length = meetings.length;
        int[] start = new int[length];
        int[] end = new int[length];
        for (int i = 0; i < meetings.length; i++) {
            start[i]=meetings[i][0];
            end[i]=meetings[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        //双指针计算
        int res=0,count =0,i=0,j=0;
        while (i<length&&j<length){
            if (start[i]<end[j]){
                count++;
                i++;
            }else {
                count--;
                j++;
            }
            res=Math.max(res,count);
        }
        return res;
    }
}
