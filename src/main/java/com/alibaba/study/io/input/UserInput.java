package com.alibaba.study.io.input;

import lombok.Data;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 10:43
 */
@Data
public class UserInput implements Comparable<UserInput>{

    private Integer age;

    private String name;

    @Override
    public int compareTo(UserInput o) {
        //当compareTo方法返回0的时候集合中只有一个元素
        //return 0;
        //当compareTo方法返回正数的时候集合会怎么存就怎么取
        return 1;
        //当compareTo方法返回负数的时候集合会倒序存储
        //return -1;
    }
}
