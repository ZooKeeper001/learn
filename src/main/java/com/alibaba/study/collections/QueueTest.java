package com.alibaba.study.collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/14 11:59
 */
public class QueueTest {

    public static void main(String[] args) {
        // 先进先出
        Queue<String> queue = new LinkedList<String>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        String poll = queue.poll();
        System.out.println(poll + "---------");
        String poll1 = queue.poll();
        System.out.println(poll1 + "---------");
        queue.forEach(
                t-> System.out.println(t)
        );
    }
}
