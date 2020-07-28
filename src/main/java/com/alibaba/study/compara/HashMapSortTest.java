package com.alibaba.study.compara;

import java.util.*;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/27 16:31
 */
public class HashMapSortTest {

    public static void main(String[] args) {
     Map<String,Integer> map = new HashMap<>();
     map.put("f",6);
     map.put("e",1);
     map.put("c",3);
     map.put("d",4);
     map.put("a",5);
     map.put("b",2);

     List<Map.Entry<String,Integer>> list=new ArrayList<>();
     list.addAll(map.entrySet());
     Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
         @Override
         public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
             return o2.getValue()-o1.getValue();
         }
     });

     list.stream().forEach(t -> System.out.println(t));
    }
}
