package com.alibaba.study.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/27 12:24
 */
public class ArrayListTest {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        ArrayList arrayList = new ArrayList(Arrays.asList(arr));
        System.out.println(arrayList.toString());

        List<String> list = new ArrayList<>(arr.length);
        Collections.addAll(list, arr);
        System.out.println(list.toString());

        List<Integer> listA=new ArrayList<>();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        listA.add(5);
        listA.add(6);

        for(Integer a:listA){
            if (a==3) {
                listA.remove(3);
            }
        }
    }
}
