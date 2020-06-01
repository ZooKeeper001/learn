package com.alibaba.study.collections;

import java.util.UUID;

/**
 * 读取 Excel 数据
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/15 13:31
 */
public class ReadExcelTest {

    public static void main(String[] args) {

        /*List<String> read = ExcelUtil.read("D:\\aa.xls");

        System.out.println(read);
        System.out.println(read.size());
        read.forEach(
                t -> System.out.println(t)
        );

        String a = "kelala:18:";
        String re = ":";
        String[] split = a.split(re);
        System.out.println(split.length);
        for (int i = 0 ;i < split.length ;i++) {
            System.out.println(split[i]);

        }*/
        UUID.randomUUID().toString();
        System.out.println(UUID.randomUUID().toString());
    }
}
