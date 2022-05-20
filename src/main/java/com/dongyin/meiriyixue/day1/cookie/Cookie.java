package com.dongyin.meiriyixue.day1.cookie;

/**
 * cookie就是服务器给每个客户端（浏览器）打的标签,将用户信息放在cookie当中，session存在服务器当中
 * 之后http请求服务器的时候带上cookie，服务器识别就会做出相应的回应
 * 但存储在 HTTP header，需要带宽，存大量信息的时候就要配合session，cookie存变量 sessionID
 * 服务器找到对应的session，session存在服务器当中，设置一个过期时间
 * 服务器中Manager管理session
 */
public class Cookie {
}
