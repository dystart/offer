package com.dongyin.leetcodetree.taixin;

/**差分数组
 * 差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减。
 * assert 相当于if，如果false则抛出异常
 * @author dystart
 * @create 2022-04-10 16:14
 */
public class Solution2 {

    //0 <= fromi < toi <= 1000
    //trips = [[2,1,5],[3,3,7]], capacity = 5
    //输出：true
    public boolean carPooling(int[][] trips, int capacity) {
        int[] ints = new int[1001];
        Difference difference = new Difference(ints);
        for (int[] trip : trips) {
            //        // 第 trip[2] 站乘客已经下车，
            //        // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            difference.add(trip[1],trip[2]-1,trip[0]);
        }

        int[] result = difference.result();
        for (int i = 0; i < result.length; i++) {
            if(result[i]>capacity){
                return false;
            }
        }
        return true;
    }




    //n表示航班多少，int[][]表示每一次预定，每一组都是第几个到第几个预定几个作为
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ints = new int[n];
        Difference difference = new Difference(ints);
        for (int[] booking : bookings) {
            int y=booking[1]-1;
            difference.add(booking[0]-1,y,booking[2]);
        }
        return difference.result();
    }



    //力扣第 370 题「 区间加法
    int[] getModifiedArray(int length, int[][] updates){
        int[] ints = new int[length];
        Difference difference = new Difference(ints);
        //每次是一组操作
        for (int[] update : updates) {
            difference.add(update[0],update[1],update[2]);
        }
        return difference.result();
    }
}

//差分工具类
class Difference{

    public int[] diff;

    //构建
    public Difference(int[] nums){
        assert nums.length<0;
        diff=new int[nums.length];
        diff[0]=nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i]=nums[i]-nums[i-1];
        }
    }

    //指定区间加值
    public void add(int left,int right,int val){
        diff[left]+=val;
        if (right<diff.length-1) {
            diff[right + 1] -= val;
        }
    }

    //返回初始结果
    public int[] result(){
        int[] result = new int[diff.length];
        result[0]=diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i]=result[i-1]+diff[i];
        }
        return result;
    }

}
