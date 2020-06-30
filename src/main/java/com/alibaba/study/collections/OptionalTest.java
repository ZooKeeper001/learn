package com.alibaba.study.collections;

import com.alibaba.study.io.input.Beauty;

import java.util.Optional;

/**
 * optional是为了解决null
 *
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/6/30 13:51
 */
public class OptionalTest {

    public static void main(String[] args) {
        Beauty beauty = new Beauty();
        beauty.setName("林允儿");
//        String name = getName(beauty.getName());
        String name = getBeautyName(beauty.getName());
        System.out.println(name);
        create(beauty);
    }

    /**
     * 常规用法
     *
     * @param beauty
     * @return
     */
    public static String getName(String beauty) {
        if (beauty == null) {
            System.out.println(111111);
            return "不知道";
        }else {
            return beauty;
        }
        //return beauty.getName();
    }

    /**
     * optional用法
     *
     * @param beauty
     * @return
     */
    public static String getBeautyName (String beauty) {
        return Optional.ofNullable(beauty).orElse("不知道");
    }

    /**
     * optional对象创建
     */
    public static void create(Beauty beauty){
        // 创建一个包装值为空的Optional对象
        Optional<Beauty> empty = Optional.empty();
        // 创建包装对象值非空的Optional对象
        Optional<Beauty> notNull = Optional.of(beauty);
        // 创建包装对象值允许为空的Optional对象
        Optional<Beauty> nullAble = Optional.ofNullable(beauty);
    }

}
