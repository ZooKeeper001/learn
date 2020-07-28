package com.alibaba.study.enumtest;

import java.util.Arrays;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/27 11:16
 */
public class EnumTest {

    public static void main(String[] args) {
        System.out.println(Color.BLACK);
        System.out.println(Status.NEW.status());
        // valueOf 取出某个实例
        Color black = Color.valueOf("BLACK");
        System.out.println(black);
        for (Color c : Color.values()) {
             System.out.println(c);
        }

        // jdk1.8之后
        Arrays.stream(Color.values()).forEach(c -> System.out.println(c));
    }
}
