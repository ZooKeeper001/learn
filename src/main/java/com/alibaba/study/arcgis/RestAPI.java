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
import reactor.core.publisher.Flux;

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
            HttpPost httpPost = new HttpPost("http://180.117.162.11:6080/arcgis/rest/services/xiangcheng/xiangcheng_shuixi/MapServer" + ArcGisConstants.BOX_QUERY_FEATURES);
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

             if (response.getStatusLine().getStatusCode() == 200) {
                   // 调用EntityUtils.toString方法最后会自动把inputStream close掉的
                   String result = EntityUtils.toString(response.getEntity());
                 JSONObject parse = (JSONObject)JSONObject.parse(result);
                 Object features = parse.get("features");
                 JSONArray jsonArray = (JSONArray)JSONObject.parse(features.toString());
                 System.out.println(jsonArray.size());
                 jsonArray.forEach(t -> {
                             JSONObject parse1 = (JSONObject)JSONObject.parse(t.toString());
                             Object attributes = parse1.get("attributes");
                             JSONObject parse2 = (JSONObject)JSONObject.parse(attributes.toString());

                             String type = (String) parse2.get("LX");
                             Double area = Double.parseDouble(parse2.get("STMJ").toString());
                     Double aDouble = Double.valueOf(String.format("%.2f", area));
                     System.out.println(type + ":::::" +aDouble);
                             Object geometry = parse1.get("geometry");
                             /*JSONObject parse3 = (JSONObject)JSONObject.parse(geometry.toString());
                             JSONArray rings = (JSONArray)parse3.get("rings");
                             JSONArray o = (JSONArray)rings.get(0);*/

                         }


                 );
             }
             // 释放资源
             httpclient.close();
           }

    public static void main(String[] args) throws Exception {
       // query();
     /*   String str = "[[[120.66923377002252,31.484764414446204],[120.66917666307256,31.484673994809043],[120.66849137877421,31.48478345039598],[120.66834385218704,31.484854834083364],[120.66834385218704,31.484902423508117],[120.66843427182425,31.484921459457837],[120.66886733316096,31.484831039820676],[120.66923377002252,31.484764414446204]]]";
        JSONArray picArray = JSONArray.parseArray(str);
        JSONArray o = (JSONArray)picArray.get(0);
        System.out.println(o.toJSONString());
        JSONArray o1 = (JSONArray)o.get(0);
        System.out.println(o1.get(0).toString());
        o.forEach(
                t -> System.out.println(t.toString())
        );*/

        JSONArray parse3 = (JSONArray)JSONObject.parse("[120.66923377002252,31.484764414446204]");
        System.out.println(parse3.get(0));
        System.out.println(parse3.get(1));
    }

}
