package com.alibaba.study.enumtest;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/27 11:28
 */
public enum Type {
    CAKE("cake"),MOVIE("movie"),SHOE("show");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String type(){
        return type;
    }
}
