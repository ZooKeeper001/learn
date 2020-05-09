package com.alibaba.study.innerclasssingleton;

/**
 * 单例模式 （静态内部类）
 * 本质上利用类的加载机制来实现线程安全
 *
 * @author: Shawn(Shawn_0108 @ 163.com)
 * @date: 2020/2/27 17:38
 * @version: 1.0
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        System.out.println(instance1 == instance2);

      new Thread( () ->{
          InnerClassSingleton instance = InnerClassSingleton.getInstance();
          System.out.println(instance);
      }).start();

        new Thread( () ->{
            InnerClassSingleton instance = InnerClassSingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}


class InnerClassSingleton{

    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){

        if (InnerClassHolder.instance == null) {
            throw new RuntimeException("单列不允许多个实列");
        }

    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

}
