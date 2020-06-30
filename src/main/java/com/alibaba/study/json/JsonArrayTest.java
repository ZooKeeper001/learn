package com.alibaba.study.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.study.io.input.Beauty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/6/1 11:53
 */
public class JsonArrayTest {

    public static void main(String[] args) {
/*        List<Beauty> beauties = new ArrayList<>();
        Beauty beauty1 = new Beauty();
        Beauty beauty2 = new Beauty();
        Beauty beauty3 = new Beauty();
        beauty1.setName("克拉拉");
        beauty1.setAge(17);
        beauty2.setName("林允儿");
        beauty2.setAge(16);
        beauty3.setName("杨紫");
        beauty3.setAge(15);
        beauties.add(beauty1);
        beauties.add(beauty2);
        beauties.add(beauty3);
        int j = 0;
        // 集合转数组
        Object[] objects = beauties.toArray();
        for (int i = 0;i <objects.length;i++) {
            j++;
            System.out.println(j);
            System.out.println(objects[i]);
        }

       String i = j +"";
        System.out.println(i.equals("0"));*/

        float dou = 3.1487426f;
        String douStr = String.format("%.2f", dou);
       // System.out.println(douStr);

        String a = "20200601";
        System.out.println(a.substring(0,6));
    }
}
