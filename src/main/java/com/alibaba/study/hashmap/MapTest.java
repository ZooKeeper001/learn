package com.alibaba.study.hashmap;

import com.alibaba.study.io.input.Person;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/28 8:49
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Person,Integer> map = new HashMap<Person,Integer>(4);
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person p4 = new Person(4);
        map.put(p1,1);
        map.put(p4,2);
        map.put(p2,3);
        map.put(p3,4);

    }
}
