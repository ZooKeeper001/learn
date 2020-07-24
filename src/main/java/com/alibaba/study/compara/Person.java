package com.alibaba.study.compara;

import lombok.Data;

import java.util.Arrays;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/24 13:55
 */
@Data
public class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age)
    {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        return this.age-p.getAge();
    }

    public static void main(String[] args) {
        Person[] people=new Person[]{new Person("xujian", 20),new Person("xiewei", 10)};
        // 排序前
        for (Person person : people) {
            System.out.print(person.getName()+":"+person.getAge());
        }
        Arrays.sort(people);
        System.out.println("排序后");
        for (Person person : people)
        {
            System.out.print(person.getName()+":"+person.getAge());
        }
    }
}
