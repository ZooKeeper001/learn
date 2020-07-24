package com.alibaba.study.compara;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/24 14:06
 */
@Data
public class Student  {

    private String name;

    private int age;

    public Student(String name, int age)
    {
        super();
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{new Student("xujian", 20),new Student("xiewei", 10)};
        System.out.println("排序前");
        for (Student student : students)
        {
            System.out.print(student.getName()+":"+student.getAge());
        }
        Arrays.sort(students,new StudentCompartor());
        System.out.println("\n排序后");
        for (Student student : students)
        {
            System.out.print(student.getName()+":"+student.getAge());
        }
    }
}
