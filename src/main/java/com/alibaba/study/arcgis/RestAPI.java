package com.alibaba.study.arcgis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.study.constants.ArcGisConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.util.*;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/26 11:01
 */
@Slf4j
public class RestAPI {
    public static String rest(String url, List<NameValuePair> formparams)
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        String responseBody = null;
        BufferedReader br = null;
        try {
            UrlEncodedFormEntity uef = new UrlEncodedFormEntity(formparams, HTTP.UTF_8);
            post.setEntity(uef);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            responseBody = httpClient.execute(post, responseHandler);
            System.out.println(responseBody);
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        return responseBody;
    }

    public static void query() throws Exception {
             // 创建HTTP客户端
             CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(ArcGisConstants.REQUEST_CONFIG).build();
             // 创建POST请求
            // 水体
            HttpPost httpPost = new HttpPost("http://183.129.170.180:6080/arcgis/rest/services/xiangcheng/xiangcheng_201912_water/MapServer" + ArcGisConstants.BOX_QUERY_FEATURES);
             // 黑臭
             //HttpPost httpPost = new HttpPost("http://183.129.170.180:6080/arcgis/rest/services/xiangcheng/xiangcheng_20191101_heichouwater/MapServer" + ArcGisConstants.BOX_QUERY_FEATURES);
             // 蓝藻
            //HttpPost httpPost = new HttpPost("http://183.129.170.180:6080/arcgis/rest/services/xiangcheng/xiangcheng_20191101_lanzaowater/MapServer" + ArcGisConstants.BOX_QUERY_FEATURES);
             // 处理请求参数
             //String where = "OBJECTID=" + "1";
             String where = "1=1";
             // 创建POST请求参数, 必须用NameValuePair
             List<NameValuePair> params = new ArrayList<>();
             // 设置传值参数类型为json
             params.add(new BasicNameValuePair("f", "json"));
             // 将拼装好的条件添加到参数中
             params.add(new BasicNameValuePair("where", where));
             // 返回所有字段
             params.add(new BasicNameValuePair("outFields", "*"));
             //设置http Post请求参数
             HttpEntity entity = new UrlEncodedFormEntity(params, ArcGisConstants.DEFAULT_CHARSET);
             httpPost.setEntity(entity);
             // 发送请求
             HttpResponse response = httpclient.execute(httpPost);
             // 处理结果集
             Map<String, Object> oldFeature = new HashMap<>();
             if (response.getStatusLine().getStatusCode() == 200) {
                   // 调用EntityUtils.toString方法最后会自动把inputStream close掉的
                   String result = EntityUtils.toString(response.getEntity());
                 JSONObject parse = (JSONObject)JSONObject.parse(result);
                 Object features = parse.get("features");

                 JSONArray jsonArray = (JSONArray)JSONObject.parse(features.toString());
                 jsonArray.forEach(t -> {
                             JSONObject parse1 = (JSONObject)JSONObject.parse(t.toString());
                             Object geometry = parse1.get("geometry");
                             JSONObject parse2 = (JSONObject)JSONObject.parse(geometry.toString());
                             JSONArray rings = (JSONArray)parse2.get("rings");
                             JSONArray o = (JSONArray)rings.get(0);

                     double x = 0.0;
                     double y = 0.0;
                     String[] arr = new String[2];
                     for (int i = 0 ;i < o.size();i++ ) {
                         JSONArray parse3 = (JSONArray)JSONObject.parse(o.get(i).toString());
                         Double x1 = Double.valueOf(parse3.get(0).toString());
                         Double y1 = Double.valueOf(parse3.get(1).toString());
                         x = x + x1;
                         y = y + y1;
                     }
                     arr[0] = String.valueOf(x/o.size());
                     arr[1] = String.valueOf(y/o.size());
                         }


                 );
             }
             // 释放资源
             httpclient.close();
             //return oldFeature;
           }

    public static void main(String[] args) throws Exception {

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("f", "json"));

        String response = RestAPI.rest("http://183.129.170.180:6080/arcgis/rest/services/shaoxing/shaoxing_2018/MapServer", formparams);
        JSONObject jsonObject = JSONObject.parseObject(response);

      /*  Map map = new HashMap();
        Set<String> set = jsonObject.keySet();
        for (String str : set) {
            System.out.println(str);
        }*/
   /*     for (Iterator iter = jsonObject.keySet(); iter.hasNext();) {
            String key = (String) iter.next();
            map.put(key, jsonObject.get(key));
        }
        System.out.println("feature:" + map.get("feature"));
        ObjectMapper objectMapper = new ObjectMapper();
        String str = map.get("feature").toString();
        JSONObject jsonObject1 = JSONObject.fromObject(str);
        Map map1 = new HashMap();
        String[] strings = new String[2];
        int i = 0;
        for (Iterator iter = jsonObject1.keys(); iter.hasNext();) {
            // System.out.println(iter);
            String key = (String) iter.next();
            map.put(key, jsonObject1.get(key));
            // System.err.println(jsonObject1.get(key));
            strings[i] = jsonObject1.get(key).toString();
            i++;
        }
        JSONObject obj = new JSONObject().fromObject(strings[0]);
        // System.err.println("OBJECTID:" + obj.get("OBJECTID"));
        Attributes attributes = (Attributes) JSONObject.toBean(obj,
                Attributes.class);
        obj = new JSONObject().fromObject(strings[1]);
        Geometry geometry = (Geometry) JSONObject.toBean(obj, Geometry.class);
        heavyMetal.setAttributes(attributes);
        heavyMetal.setGeometry(geometry);
        return heavyMetal;*/
        query();
    }

}
