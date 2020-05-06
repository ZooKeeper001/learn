package com.alibaba.study.hungrysingleton;

public class HungrySingletonTest {

    public static void main(String[] args) {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

/**
 * 饿汉模式
 *  类加载阶段就完成实列的初始化，本质是借助JVM类加载机制，确保实列的唯一性
 *
 *  类加载过程
 *  1. 加载二进制数据到内存中，生成对应的Class数据结构
 *  2. 连接 a.验证 b.准备（给静态成员变量赋默认值） c.解析
 *  3.初始化:给类的静态变量赋初值
 */
class HungrySingleton{

    private static HungrySingleton instance = new HungrySingleton();

    // 私有构造函数
    private HungrySingleton(){

    }

    public static HungrySingleton getInstance() {

        return instance;
    }
}