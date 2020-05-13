package com.alibaba.study.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/13 14:50
 */
public class TreeSetTest {

    public static void main(String[] args) {
        Set<Person> set = new TreeSet(new Person());
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        p1.setName("a");
        p1.setAge(9);
        p2.setName("aa");
        p2.setAge(13);
        p3.setName("aaa");
        p3.setAge(13);
        // 按照名字的长度进行排序
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.forEach(
                t -> System.out.println(t)
        );
    }
}
