package com.alibaba.study.collections;

import lombok.Data;

import java.util.Comparator;

/**
 * TreeSet测试类
 *
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/13 14:50
 */
@Data
public class Person implements Comparator<Person> {
    /**
     * 实现Comparable接口
     */
    private Integer age;

    private String name;

    public Person() {
    }

    public Person(Integer age ,String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public int compare(Person o1,Person o2) {
        int num = o1.getAge() - o2.getAge();
        return num == 0 ? o1.getName().compareTo(o2.getName()) : num;
    }
}
