package com.dongyin.leetcodetree.jingdong;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author dystart
 * @create 2022-04-15 15:51
 */
public class Solution {
    double f = 111231.5585;
    public void m1() {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
    /**
     * DecimalFormat转换最简便
     */
    public void m2() {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));
    }
    /**
     * String.format打印最简便
     */
    public void m3() {
        System.out.println(String.format("%.2f", f));
    }
    public void m4() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            int m=scanner.nextInt();
//            double sum = sum(num, m);
//
//            System.out.printf("%.2f",sum);
//            System.out.println();
            Shui(num,m);
        }
    }

    public static double sum(int num,int m){
        if (num<0||m<1)return 0;
        double numD=num;
        double sum=numD;
        while (m>1){
            numD=Math.sqrt(numD);
            sum+=numD;
            m--;
        }
        return sum;
    }


    public static void Shui(int n,int m){
        boolean b=false;
        for (int i = n; i <= m; i++) {
            int Bnum=i/100;
            int Snum=(i-Bnum*100)/10;
            int Gnum=i%10;
            if (i==Math.pow(Bnum,3)+Math.pow(Snum,3)+Math.pow(Gnum,3)){
                System.out.print(i+" ");
                b=true;
            }
        }
        if (!b){
            System.out.println("no");
        }
    }
}
