package com.liyuan.zero.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by liyuan on 2018/9/1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
