package com.liyuan.zero.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具栏
 * Created by liyuan on 2018/9/1
 */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    private static final Logger log = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     *
     * @param cls 类
     * @return 实例对象
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            log.error("new instance failure {}", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 创建实例（根据类名）
     */
    public static Object newInstance(String className) {
        Class<?> cls = ClassUtil.loadClass(className);
        return newInstance(cls);
    }

    /**
     * 调用方法
     * @param obj 对象实例
     * @param method 执行的方法
     * @param args 参数
     * @return 执行结果
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        //值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查。
        //实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            log.error("invoke method failure {}", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param obj 对象实例
     * @param field 成员变量
     * @param value 值
     */
    public static void setField(Object obj,Field field,Object value){
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            log.error("set field failure {}",e);
            throw new RuntimeException(e);
        }
    }

}
