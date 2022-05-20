package com.dongyin.offer;

import org.junit.Test;

/**
 * @author dystart
 * @create 2022-03-15 22:26
 */
public class Basic {
    //创建一个打印类
    public class Print {
        public void prints() {
            System.out.println("打印");
        }
    }


    //创建个黑白打印类继承打印类
    public class BWprint extends Print {
        public void prints() {
            System.out.println("已进行黑白打印!");
        }
    }

    //创建一个彩色打印继承打印类
    public class CLprint extends Print {
        public void prints() {
            System.out.println("以进行彩色打印！");
        }
    }


    //创建一个测试类
    @Test
    public void Test1() {
        Print print = new BWprint();//引用print类型，用BWprin类t实例化
        Print print1 = new CLprint();//引用print类型，用CLprint类实例化
        //都是print类型,prints方法，但输出结果却不同
        print.prints();
        print1.prints();
    }
}


