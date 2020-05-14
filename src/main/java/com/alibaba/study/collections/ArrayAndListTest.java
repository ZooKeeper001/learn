package com.alibaba.study.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/13 16:49
 */
public class ArrayAndListTest {

    public static void main(String[] args) {
        // 数组转List
        Person p1 = new Person(18,"克拉拉");
        Person p2 = new Person(19,"允儿");
        Person p3 = new Person(20,"李沁");
        Person[] arr = {p1,p2,p3};
        List<Person> people = Arrays.asList(arr);
      /*  people.forEach(
                t -> System.out.println(t)
        );
*/
        // 集合转数组
      /*  Person[] a = new Person[people.size()] ;
        people.toArray(a);
        for (int i = 0;i<a.length;i++) {
            System.out.println(a[i]);
        }*/

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        /*set.forEach(
                t -> System.out.println(t)
        );*/
        Person[] b = new Person[set.size()];
        set.toArray(b);
        for (int i = 0;i<b.length;i++) {
            System.out.println(b[i]);
        }
    }
}
