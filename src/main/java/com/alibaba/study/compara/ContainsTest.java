package com.alibaba.study.compara;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/24 16:25
 */
public class ContainsTest {

    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        String[] b = {"a", "b", "c"};
        // 数组转集合
        boolean contains1 = Arrays.asList(b).contains("a");
        boolean contains = IntStream.of(a).anyMatch(x -> x == 4);
        List<String> strings = Arrays.asList(b);
        boolean b1 = strings.contains("b");

        System.out.println(b1);
        System.out.println(contains1);
        System.out.println(contains);
    }
}
