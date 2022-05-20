package com.dongyin.offer;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author dystart
 * @create 2022-03-19 13:11
 */
public class RedisTest {

    public RedisTest(){}
    public RedisTemplate redisTemplate;

    public RedisTemplate redisTemplate(){
        System.out.println("hhh");
        return redisTemplate = new StringRedisTemplate();
    }

    @Test
    public void testRedis(){
        RedisTemplate redisTemplate = redisTemplate();
    }

    public RedisTest(Integer integer){

    }
}

class PersonTest extends RedisTest implements Cloneable{

    public PersonTest(){

    }

    public PersonTest(Integer integer) {
        super(integer);
    }

    public void test(){
        System.out.println("我睡觉");
    }

    public static void main(String[] args) throws Exception {
        PersonTest personTest = (PersonTest) Class.forName("com.dongyin.offer.PersonTest").newInstance();
        personTest.test();
        PersonTest personTest1 = new PersonTest();
        PersonTest clone = (PersonTest)personTest1.clone();
        clone.test();

    }


}
