package com.dongyin.leetcodetree.jingdong;

import java.util.*;

/**
 * @author dystart
 * @create 2022-04-15 12:21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //组树
        int number =scanner.nextInt();
        String zifu=scanner.next();
        char c = zifu.charAt(0);
        for (int i = 0; i < number; i++) {
            //长度
            int leng = scanner.nextInt();
            int[] ints = new int[leng];
        for (int j = 0; j < leng; j++) {
                ints[j]=scanner.nextInt();
            }
            System.out.println(maxZhong(ints));
        }
    }

    public static int maxZhong(int[] ints){
        if (ints.length==1){
            return ints[0];
        }
        int max;
        int[] res = new int[ints.length / 2];
        for (int i = 0; i < res.length; i++) {
            res[i]=ints[2*i+1];
        }
        max=res[res.length/2];
        return max;
    }
}

//    @Test
//    public void test1(){
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        System.out.println(s);
//    }


//    public static void main(String[] args) {
//        int res=0;
//        Scanner scanner = new Scanner(System.in);
//        //表示几段代码需要判断
//        int number =scanner.nextInt();
//        String temp="";
//        boolean flag = false;
//        for (int i = 0; i < number; i++) {
//            //几行判断
//            int nums = scanner.nextInt();
//            int hang=nums;
//            String shangyige="";
//            for (int j = 0; j < nums; j++) {
//                temp=scanner.next();
//                hang--;
//                if (temp.length()>=3&&temp.substring(0,3).equals("end")){
//                    res--;
//                    String next = scanner.next();
////                    System.out.println(next);
////                    System.out.println(shangyige);
//                    if (!next.equals(shangyige)){
//                        flag=true;
//                        break;
//                    }
//                }else {
//                    shangyige=temp;
//                    res++;
//                }
//                if(hang==0){
//                    break;
//                }
//            }
//            if (res==0&&!flag){
//                System.out.println("Yes");
//            }if (res!=0||flag){
//                System.out.println("No");
//                res=0;
//                flag=false;
//            }
//        }
//    }
//
//}
class Mai{

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        //n个人,左边看到x，右边看到y
        int n=scanner.nextInt();
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        int[] strength=new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            strength[i]=scanner.nextInt();
        }
        for(int j=0;j<n;j++){
            if(min(strength,j,x,y)){
                res=j+1;
                break;
            }
        }
        System.out.println(res);
    }

    //判断ints[i] 在x到y是否为最小
    final public static boolean min(int[] ints,int i,int x,int y){
        int length=ints.length;
        if(i-x<0){x=0;}
        if(i+y>length-1){y=length-1;}
        for(int j=x;j<=y;j++){
            if(ints[j]<ints[i]){
                return false;
            }
        }
        return true;
    }

    //判断ints[i] 在x到y是否为最小
    final public static boolean min(int[] ints,int i,int x,int y,int c){
        int length=ints.length;
        if(i-x<0){x=0;}
        if(i+y>length-1){y=length-1;}
        for(int j=x;j<=y;j++){
            if(ints[j]<ints[i]){
                return false;
            }
        }
        return true;
    }



}
