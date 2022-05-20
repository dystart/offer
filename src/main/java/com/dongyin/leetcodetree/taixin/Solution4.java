package com.dongyin.leetcodetree.taixin;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Thread.sleep;

/**视频剪辑贪心算法
 * @author dystart
 * @create 2022-04-11 0:55
 */
public class Solution4 {
    public static void main(String[] args) {
        int[] ints = {2, 5, 77, 45, 33};
        sleepSort(ints);
    }

    public static void sleepSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            final int j=nums[i];
            new Thread(()->{
                try {
                    sleep(j);
                    System.out.println(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }



    //保证有起点，并且终点最长,O(NlogN)
    public int videoStitching(int[][] clips, int time) {
        if (time==0)return 0;
        //按照七点升序排列
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    //终点降序
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        //endCur为当前的终点，nextEnd为真正的终点最远的终点
        int res=0,endCur=0,nextEnd=0,i=0;
        int n=clips.length;
        //起点小于终点才有可能拼接
        while (i<n&&clips[i][0]<=endCur){
            //在可能拼接的里面找最远的终点,所以起点小于当前终点的里面找出终点最远
            while (i<n&&clips[i][0]<=endCur){
                nextEnd=Math.max(nextEnd,clips[i][1]);
                i++;
            }
            res++;
            endCur=nextEnd;
            if (endCur>=time){
                return res;
            }
        }
        return -1;
    }
}
