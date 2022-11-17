package org.example.test.hump;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BeanHump.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/3
 * @since 1.0
 */
public class BeanHump {

    //转变的依赖字符
    public static final char underline = '_';

    /**
     * 将驼峰转换成"_"(userid:user_id)
     *
     * @param param
     * @return
     */
    public static String camel2underline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(underline);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将"_"转成驼峰(user_id:userid)
     *
     * @param param
     * @return
     */
    public static String underline2camel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == underline) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将"_"转成驼峰(user_id:userId)
     *
     * @param param
     * @return
     */
    public static String underline2camelV2(String param) {

        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);
        Matcher mc = Pattern.compile(underline + "").matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            String.valueOf(Character.toUpperCase(sb.charAt(position)));
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }

    /*
     * 测试
     */
    public static void main(String[] args) {

        System.out.println(camel2underline("usernameall"));
        System.out.println(underline2camel("user_name_all"));
        System.out.println(underline2camelV2("user_name_all"));
    }

}
