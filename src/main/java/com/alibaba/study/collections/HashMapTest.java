package com.alibaba.study.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/13 16:07
 */
public class HashMapTest {

    public static void main(String[] args) {
        // 初始化时尽量指定集合的大小
        Map<Integer,String> map = new HashMap<>(3);
        map.put(100,"允儿");
        map.put(1,"克拉拉");
        map.put(2,"李沁");
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            Integer mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }
    }
}
