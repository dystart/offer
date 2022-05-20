package com.dongyin.offer;

import org.junit.Test;

import java.io.*;

// 目标类
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    public Elvis() {
        System.out.println("no parameters constructor invoked!");
    }


    // 测试
    @Test
    public void testSerialization() throws Exception {
        Elvis elvis1 = Elvis.INSTANCE;
        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(elvis1);
        oos.flush();
        oos.close();

        Elvis elvis2 = null;
        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        elvis2 = (Elvis) ois.readObject();

        System.out.println("elvis1与elvis2相等吗？ ===> " + (elvis1 == elvis2));
    }
}
