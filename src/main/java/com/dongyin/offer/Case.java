package com.dongyin.offer;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author dystart
 * @create 2022-03-22 0:28
 */
public class Case extends Thread {



    @Override
    public void run(){
        System.out.println("hhhhhh");
    }

    public static void main(String[] args) {
        int x=1;
        switch (x){
            case 1:
                System.out.println("hhh");
                break;
            case 2:
                System.out.println("hh");
        }



        Student[] array = new Student[2];
        array[0]=new Student() {
            @Override
            public void add() {

            }

            @Override
            public String select() {
                return null;
            }
        };


    }

    @Test
    public void testHash(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        Integer put = hashMap.put("1", 1);
        Integer put1 = hashMap.put("1", 1);
        System.out.println(put);
        System.out.println(put1);

        Thread thread = new Thread(new Case());
        thread.start();

        Thread thread1 = new Thread(() -> {
            System.out.println("suicjkhjc ");
//            Thread.currentThread().wait();

        }, "aa");
        thread1.start();
        thread1.interrupt();

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(5);

        System.out.println(threadLocal.get());
    }



}
