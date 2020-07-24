package com.alibaba.study.compara;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/24 16:25
 */
public class ContainsTest {

    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        String[] b = {"a", "b", "c"};
        boolean contains1 = Arrays.asList(b).contains("a");
        boolean contains = IntStream.of(a).anyMatch(x -> x == 4);

        System.out.println(contains1);
        System.out.println(contains);
    }
}
