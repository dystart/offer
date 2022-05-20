package com.dongyin.offer;

/**
 * @author dystart
 * @create 2022-03-22 0:11
 */
public interface Abstract {

    int AD=0;

    default void test(){
        System.out.println("我手机");
    }

    static void add() {
        System.out.println();
    }
}
