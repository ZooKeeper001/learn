package com.alibaba.study.files;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/18 13:14
 */
@Slf4j
public class ABC {

    public static void main(String[] args) {
        String[] arr = new String[2];
        arr[0] = String.valueOf(1.1);
        arr[1] = String.valueOf(2.2);
        for (int i = 0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
        System.out.println(arr.toString());
    }
}
