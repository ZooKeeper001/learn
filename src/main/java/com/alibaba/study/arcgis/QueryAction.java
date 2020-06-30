package com.alibaba.study.arcgis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/26 11:00
 */
public class QueryAction {
    public void queryByObjectid(int objectid) {/*
        HeavyMetal heavyMetal = new HeavyMetal();
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("f", "json"));
//queryurl=http://192.168.24.218/ArcGIS/rest/services/HeavyMetal/FeatureServer/0/11(11是objectid)
        String response = RestAPI.rest(Constants.queryurl + objectid,
                formparams);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Map map = new HashMap();
        for (Iterator iter = jsonObject.keys(); iter.hasNext();) {
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
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "[120.6455472595984,31.42698205477808]";
      /*  JSONArray coordinates1 = (JSONArray);
        System.out.println(coordinates1.toJSONString());
        double x = 0.0;
        double y = 0.0;
        for (int i = 0 ;i < coordinates1.size();i++ ) {
            JSONArray parse3 = (JSONArray) JSONObject.parse(coordinates1.get(i).toString());
            Double x1 = Double.valueOf(parse3.get(0).toString());
            Double y1 = Double.valueOf(parse3.get(1).toString());
            x = x + x1;
            y = y + y1;
        }
        System.out.println(x);
        System.out.println(y);*/
    }

}
