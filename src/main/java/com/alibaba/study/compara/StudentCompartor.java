package com.alibaba.study.compara;

import java.util.Comparator;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/24 14:13
 */
public class StudentCompartor implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2)
    {
        return o1.getAge()-o2.getAge();
    }

    public static int factorial (int n) {

        if (n == 1) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) {
        int t = factorial(5);
        System.out.println(t);
    }

}
