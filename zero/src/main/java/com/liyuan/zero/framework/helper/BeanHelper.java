package com.liyuan.zero.framework.helper;

import com.liyuan.zero.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean 助手类（类似Bean容器）
 * Created by liyuan on 2018/9/1
 */
public final class BeanHelper {
    private BeanHelper() {
    }

    /**
     * 定义BeanMap存放实例化好的Bean与Bean类的关系
     */
    public static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();


    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object instance = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, instance);
        }
    }

    /**
     * 获取Bean映射
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class :" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

}
