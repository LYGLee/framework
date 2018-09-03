package com.liyuan.zero.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 提取属性
 * Created by liyuan on 2018/8/22
 */
public final class PropsUtil {

    private static final Logger log = LoggerFactory.getLogger(PropsUtil.class);

    private PropsUtil() {
    }

    /**
     * 加载属性文件
     *
     * @param fileName 文件名
     * @return 属性对象
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + "file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            log.error("load properties file failure", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("close input stream failure", e);
                }
            }
        }
        return props;
    }


    /**
     * 获取字符型属性（默认值为空字符串）
     *
     * @param props 属性对象
     * @param key   键
     * @return 属性值
     */
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    /**
     * 获取字符型属性（默认值为空字符串）
     *
     * @param props        属性对象
     * @param key          键
     * @param defaultValue 默认值
     * @return 属性值
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性
     * @param props 属性对象
     * @param key 键
     * @return 值
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);

    }

    /**
     * 获取数值型属性
     * @param props 属性对象
     * @param key 键
     * @param defaultValue 默认值
     * @return 值
     */
    public static int getInt(Properties props, String key, int defaultValue) {
            int value = defaultValue;
            if(props.containsKey(key)){
                value = CastUtil.castInt(props.getProperty(key));
            }
            return value;
    }


    /**
     * 获取布尔型属性（默认值为 false）
     * @param props 属性对象
     * @param key 键
     * @return 值
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * 获取布尔型属性（可指定默认值）
     * @param props 属性对象
     * @param key 键
     * @param defaultValue 默认值
     * @return 值
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}
