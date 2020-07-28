package com.alibaba.study.compara;

import org.springframework.util.Assert;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/27 9:28
 */
public class StringTest {

    public static void main(String[] args) {
        // 内部存储结构为char数组
        String s1 = "Hello World";
        String s2 = "Hello World";

        // s1 s2指针地址其实时一样的，也就是说他们代表了同一个对象
        // 当s2声明的时候，jvm发现常量池已存在该对象，所以不会再创建一次，而是直接将一样的内存指针赋值给s2，避免重复创建对象，节省了内存空间
        System.out.println(s1 == s2);

        StringBuilder stringBuilder = new StringBuilder("123");
        stringBuilder.append("456");
        System.out.println(stringBuilder.toString());
    }
}
