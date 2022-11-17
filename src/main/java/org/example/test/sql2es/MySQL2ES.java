package org.example.test.sql2es;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.example.test.hump.BeanHump;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedHashMap;

/**
 * MySQL2ES.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/1
 * @since 1.0
 */
public class MySQL2ES {

    public void sql2java(String type, String name, String comment) {

        String javaType = null;
        if (type.startsWith("bigint")) {
            javaType = "Long";
        }

        if (type.startsWith("int") || type.startsWith("tinyint")) {
            javaType = "Integer";
        }

        if (type.startsWith("date")) {

            javaType = "Date";
        }

        if (type.startsWith("varchar") || type.startsWith("text") || type.startsWith("mediumtext")) {
            javaType = "String";
        }

        if (type.startsWith("decimal")) {
            javaType = "BigDecimal";
        }

        String s = "    /**\n" +
                "     * " + comment
                + "\n" +
                "     */\n" +
                "    @JsonProperty(\"" + name
                + "\")\n" +
                "    private " + javaType + " " + BeanHump.underline2camel(name) + ";";

        if ("Date".equals(javaType)) {

            s = "    /**\n" +
                    "     * " + comment
                    + "\n" +
                    "     */\n" +
                    "    @JsonProperty(\"" + name
                    + "\")\n" +
                    "    @JsonFormat(\n" +
                    "            pattern = \"yyyy-MM-dd HH:mm:ss\",\n" +
                    "            timezone = \"GMT+8\"\n" +
                    "    )\n"
                    + "    private " + javaType + " " + BeanHump.underline2camel(name) + ";";

        }

        System.out.println(s);
        System.out.println();
    }

    public void sql2es(String type, String key, JSONObject resultJSON) {

        if (type.startsWith("bigint")) {

            JSONObject typeJSON = MySQL2ESType.typeMap.get("long");
            if (typeJSON == null) {
                throw new RuntimeException(key + type + "找不到");
            }
            resultJSON.put(key, typeJSON);
            return;
        }

        if (type.startsWith("int") || type.startsWith("tinyint")) {

            JSONObject typeJSON = MySQL2ESType.typeMap.get("int");
            if (typeJSON == null) {
                throw new RuntimeException(key + type + "找不到");
            }
            resultJSON.put(key, typeJSON);
            return;
        }

        if (type.startsWith("date")) {

            JSONObject typeJSON = MySQL2ESType.typeMap.get("date");
            if (typeJSON == null) {
                throw new RuntimeException(key + type + "找不到");
            }
            resultJSON.put(key, typeJSON);
            return;
        }

        if (type.startsWith("varchar(512)") || type.startsWith("text") || type.startsWith("mediumtext")) {
            JSONObject typeJSON = MySQL2ESType.typeMap.get("text");
            if (typeJSON == null) {
                throw new RuntimeException(key + type + "找不到");
            }
            resultJSON.put(key, typeJSON);
            return;
        }

        if (type.startsWith("varchar")) {
            JSONObject typeJSON = MySQL2ESType.typeMap.get("keyword");
            if (typeJSON == null) {
                throw new RuntimeException(key + type + "找不到");
            }
            resultJSON.put(key, typeJSON);
            return;
        }

        if (type.startsWith("decimal")) {
            JSONObject typeJSON = MySQL2ESType.typeMap.get("double");
            if (typeJSON == null) {
                throw new RuntimeException(key + type + "找不到");
            }
            resultJSON.put(key, typeJSON);
            return;
        }


        String message = String.format("%s-%s找不到对应类型", type, key);
        throw new RuntimeException(message);

    }


    /**
     * 读取内容
     * @param path
     * @return
     */
    public String readFile(String path) {

        File file = new File(path);
        StringBuilder result = new StringBuilder();

        JSONObject resultJSON = new JSONObject(new LinkedHashMap<String, Object>());

        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8));

            String s = null;

            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {

                s = s.trim();

                if (!s.startsWith("`")) {
                    continue;
                }

//                System.out.println(s);
                String[] columnString = s.split(" ");

                // 处理key
                String index0 = columnString[0];
                String key = index0.substring(1, index0.length() - 1);

                // 处理字段类型
                String type = columnString[1];

                String[] arr2 = s.split("COMMENT ");
                String comment = arr2[arr2.length - 1];
                comment = comment.substring(1, comment.length() - 2);

                // 输出 Java 代码
                sql2java(type, key, comment);

                sql2es(type, key, resultJSON);
//                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(resultJSON, SerializerFeature.DisableCircularReferenceDetect);
    }

}



