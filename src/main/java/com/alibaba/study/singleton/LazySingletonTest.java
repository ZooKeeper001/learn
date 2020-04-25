package com.alibaba.study.singleton;

public class LazySingletonTest {

    public static void main(String[] args) {
        /*LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance1 == instance2); // true*/

        new Thread( () -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread( () -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

/**
 * 单列 使用场景（控制实例数目，节省系统资源的时候）
 * 意图  一个全局使用的类频繁的创建和销毁
 *
 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。
 * 这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象
 */
class LazySingleton{

    // 实例
    // volatile 不会发生重排序 按照既定的指令执行
    // 字节码层 1.分配空间 2.初始化 3.赋值
    private volatile static LazySingleton instance;

    /**
     * 私有的构造函数
     */
    private LazySingleton() {

    }

    /**
     * 提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象
     */
    public static LazySingleton getInstance() {

        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    };
}
