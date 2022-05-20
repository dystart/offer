package com.dongyin.meituan;

/**
 * @author dystart
 * @create 2022-04-09 16:31
 */
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int[] sumNum = new int[sum];
        for (int i = 0; i < sum; i++) {
            sumNum[i]=i;
        }
        int[] ints = new int[4];
        int solution = solution(ints, sumNum);
        System.out.println(solution);
    }

    public static int solution(int[] ints,int[] sum){
        if (sum.length==1){
            return 0;
        }
        int j=sum.length-1;
        int res=0;
        while (true){
            if (j==0){
                break;
            }
            for (int i = 0; i < ints.length; i++) {
                if (j==0){
                    j=sum.length-1;
                }
                ints[i]=sum[j--];
            }
            if (ints[0]==ints[1]||ints[0]==ints[2]||ints[1]==ints[3]){
                continue;
            }
            res++;
        }
        return res;
    }

}
