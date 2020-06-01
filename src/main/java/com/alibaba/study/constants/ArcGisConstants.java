package com.alibaba.study.constants;

import org.apache.http.client.config.RequestConfig;

/**
 * arcgis常量类
 *
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/26 10:32
 */
public class ArcGisConstants {

    /** 设置请求参数:
     *
     *  setConnectionRequestTimeout: 设置从连接池中取连接的超时时间
     *  setConnectTimeout: 设置连接超时时间
     *  setSocketTimeout: 设置请求超时时间
     */
    public static final RequestConfig REQUEST_CONFIG = RequestConfig.custom().setConnectionRequestTimeout(1000 * 10).setConnectTimeout(1000 * 10).setSocketTimeout(1000 * 10).build();


    /********** 定义通用常量 **********/

    /**
     * features
     */
    public static final String FEATURES = "features";

    /**
     * 控件模型
     */
    public static final String GEOMETRY = "geometry";

    /**
     * 数据模型
     */
    public static final String ATTRIBUTES = "attributes";

     /**
     * 请求的编码格式
     */
     public static final String DEFAULT_CHARSET = "UTF-8";


   /********** 定义通用字段 **********/

    /**
     * 添加box的url
     */
   public static final String BOX_ADD_FEATURES = "/0/addFeatures";

    /**
     * 更改box的url
     */
   public static final String BOX_UPDATE_FEATURES = "/0/updateFeatures";

    /**
     * 删除box的url
     */
   public static final String BOX_DELETE_FEATURES = "/0/deleteFeatures";

    /**
     * 查询box的url
     */
   public static final String BOX_QUERY_FEATURES = "/0/query";

    /**
     *  where查询条件
     */
    public static final String QUERY_CONDITION = "1=1";

    public static void main(String[] args) {
        String area = "222321";
        int i = area.indexOf(".");
        String substring = area.substring(0);
        System.out.println(i);
        System.out.println(substring);
    }
}
