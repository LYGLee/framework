package com.zero.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * Created by liyuan on 2018/8/22
 */
public final class StringUtil {

    private StringUtil() {
    }

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}