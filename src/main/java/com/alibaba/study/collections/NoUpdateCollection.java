package com.alibaba.study.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/15 8:36
 */
public class NoUpdateCollection {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("集合不可被更改，否则报错");
        //Collection<String> clist = Collections.unmodifiableCollection(list);
        //clist.add("运行时报错");
        System.out.println(list.size());
    }
}
