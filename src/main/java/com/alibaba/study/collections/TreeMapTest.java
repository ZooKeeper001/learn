package com.alibaba.study.collections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/13 15:44
 */
public class TreeMapTest {

    public static void main(String[] args) {
        // TreeMap中的元素，按照key的自然排序排列，对于Integer来说，其自然排序就是升序，对于String来说，其自然排序就是按照字母表进行排序
        Map<Integer,String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(100,"允儿");
        map.put(1,"克拉拉");
        map.put(2,"李沁");
        map.clear();
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            Integer mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }
    }
}
