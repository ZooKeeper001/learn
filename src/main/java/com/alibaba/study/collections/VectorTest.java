package com.alibaba.study.collections;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/14 11:32
 */
public class VectorTest {

    public static void main(String[] args) {

        Vector<Person> people = new Vector<>();
        Person p = new Person();
        p.setAge(18);
        p.setName("克拉拉");
        people.add(p);

        people.forEach(
                t -> System.out.println(t)
        );

    }
}
