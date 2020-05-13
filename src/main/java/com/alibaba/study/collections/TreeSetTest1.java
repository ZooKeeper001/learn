package com.alibaba.study.collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/13 15:12
 */
public class TreeSetTest1 implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {        //按照字符串的长度比较
        int num = s1.length() - s2.length();        //长度为主要条件
        return num == 0 ? s1.compareTo(s2) : num;    //内容为次要条件
    }

    public static void demoTwo() {

        //需求:将字符串按照长度排序
        TreeSet<String> ts = new TreeSet<>(new TreeSetTest1());        //Comparator c = new CompareByLen();
        ts.add("aaaaaaaa");
        ts.add("z");
        ts.add("wc");
        ts.add("nba");
        ts.add("cba");

        System.out.println(ts);
    }

    public static void main(String[] args) {
        demoTwo();
    }
}