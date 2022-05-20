package com.dongyin.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author dystart
 * @create 2022-03-18 16:39
 */
public class InterFaceTest {
    @Test
    public void testException()throws Exception{
        try {
            System.out.println("我睡觉哦");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("你睡觉");
            //throw new InterruptedException();
        }
    }


}

abstract  class Person extends InterFaceTest{
    public static void main(String[] args) {
//        System.out.println("我爱");
//        String s = "啊哈哈哈哈";
//        s="";
//        StringBuffer stringBuffer = new StringBuffer(s);
//        StringBuffer append = stringBuffer.append(stringBuffer);
//        String s1 = append.toString();
//        System.out.println(s == s1);


        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if ("2".equals(next)){
//                iterator.remove();
//            }
//        }
        for (String o : list) {
            if ("2".equals(o)){
                System.out.println(list);
                list.remove(o);
                System.out.println(list);
            }
        }
        System.out.println(list);
    }

    public Person(){
        super();
    }

    private int age ;
    public String username ;

    public abstract void setAge();

    public String test(){
        return "";
    }

    public String add() throws Exception {
        super.testException();

        System.out.println("wooooo");

        return null;

    }
}

interface Student{
    public String name = "";
    public void add();

    public String select();
}
