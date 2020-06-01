package com.alibaba.study.collections;

import com.alibaba.study.io.input.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/25 8:45
 */
public class ListFilterTest {

    public static void main(String[] args) {

        List<UserInput> users = new ArrayList<>();

        List<String> names = new ArrayList<>();
        names.add("克拉拉");
        names.add("林允儿");
        names.add("金智贤");

        UserInput user1 = new UserInput();
        UserInput user2 = new UserInput();
        UserInput user3 = new UserInput();
        user1.setName("克拉拉");
        user2.setName("林允儿");
        user3.setName("金智贤");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<UserInput> collect = users.stream().filter(t -> ! names.contains(t.getName())).collect(Collectors.toList());
        System.out.println(collect.toString());

    }
}
