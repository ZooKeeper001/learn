package com.alibaba.study.hashmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/28 10:51
 */
public class SetTest {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
