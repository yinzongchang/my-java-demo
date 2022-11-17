package org.example.test.sql2es;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MySQL2ESType.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/1
 * @since 1.0
 */
public class MySQL2ESType {

    public static final Map<String, JSONObject> typeMap = new HashMap<>();

    static {

        // text
        JSONObject text = JSONObject.parseObject("{\n" +
                "                    \"type\":\"text\",\n" +
                "                    \"fields\":{\n" +
                "                        \"keyword\":{\n" +
                "                            \"ignore_above\":256,\n" +
                "                            \"type\":\"keyword\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                }");

        typeMap.put("text", text);

        // keyword
        JSONObject keyword = new JSONObject();
        keyword.put("type", "keyword");
        typeMap.put("keyword", keyword);

        // long
        JSONObject longJSON = new JSONObject();
        longJSON.put("type", "long");
        typeMap.put("long", longJSON);

        // integer
        JSONObject intJSON = new JSONObject();
        intJSON.put("type", "integer");
        typeMap.put("int", intJSON);

        // date
        JSONObject dateJSON = new JSONObject(new LinkedHashMap<>());
        dateJSON.put("type", "date");
        dateJSON.put("format", "yyyy-MM-dd||yyyy-MM-dd HH:mm:ss.SSS||yyyy-MM-dd HH:mm:ss||epoch_millis");
        typeMap.put("date", dateJSON);

        JSONObject decimalJSON = new JSONObject();
        decimalJSON.put("type", "double");
        typeMap.put("double", decimalJSON);

    }


}
