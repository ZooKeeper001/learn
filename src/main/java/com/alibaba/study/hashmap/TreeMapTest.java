package com.alibaba.study.hashmap;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/28 10:08
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"a");
        treeMap.put(3,"c");
        treeMap.put(2,"b");

        for (Map.Entry<Integer,String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
