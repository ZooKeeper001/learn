package com.alibaba.study.generics;

import java.util.List;

/**
 * 泛型测试类
 *
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/15 15:55
 */
public class GenericsTest {

    public static void main(String[] args) {
        // <T> T 表示返回值T是泛型 ，T是一个占位符
    }

    public static <T> T get1(List<T> data) {

        if (data == null || data.size() == 0) {
            return null;
        }
        return data.get(0);
    }

}
