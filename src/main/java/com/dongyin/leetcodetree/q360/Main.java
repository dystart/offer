package com.dongyin.leetcodetree.q360;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dystart
 * @create 2022-04-16 14:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //排序的数组长度
        int arrayNum=scanner.nextInt();
        //表示操作数，操作几次
        int arraySou=scanner.nextInt();
        int[] ints = new int[arrayNum];
        for (int i = 0; i < arrayNum; i++) {
            ints[i]=scanner.nextInt();
        }
        int Option=-1,end=0;
        for (int i = 0; i < arraySou; i++) {
            Option=scanner.nextInt();
            end=scanner.nextInt();
            if (Option==1){
                DownSort(ints,end);
            }
            if (Option==0){
                UpSort(ints,end);
            }
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }

    //end不参与排序
    public static void UpSort(int[] ints,int end){
        boolean falg=true;
        int min=ints[0],location=0;
        for (int i = 0; i < end; i++) {
            for (int j = i; j < end; j++) {
                if (ints[j]<min){
                    min=ints[j];
                    location=j;
                    falg=false;
                }
            }
            if(falg){
                continue;
            }else {
                falg=true;
            }
            int temp=ints[location];
            ints[location]=ints[i];
            ints[i]=temp;
            min=Integer.MAX_VALUE;
        }
    }

    public static void DownSort(int[] ints,int end){
        boolean falg=true;
        int max=ints[0],location=0;
        for (int i = 0; i < end; i++) {
            for (int j = i; j < end; j++) {
                if (ints[j]>max){
                    max=ints[j];
                    location=j;
                    falg=false;
                }
            }
            if(falg){
                continue;
            }else {
                falg=true;
            }
            int temp=ints[location];
            ints[location]=ints[i];
            ints[i]=temp;
            max=Integer.MIN_VALUE;
        }
    }





    @Test
    public void test(){
        int[] ints={1,5,4,3};
        DownSort(ints,3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}



















//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String string=scanner.next();
//        int test = test(string);
//        System.out.println(test);
//    }
//
//    public static int test(String string){
//        int res=0,temp=1;
//        char[] chars = string.toCharArray();
//        Arrays.sort(chars);
//        for (int i = 0; i < chars.length-1; i++) {
//            if (chars[i]==chars[i+1]){
//                temp++;
//                res=Math.max(temp,res);
//            }
//            if (chars[i]!=chars[i+1]){
//                temp=1;
//            }
//        }
//        return res;
//    }




