package com.liyuan.zero.framework;

import com.liyuan.zero.framework.helper.BeanHelper;
import com.liyuan.zero.framework.helper.ClassHelper;
import com.liyuan.zero.framework.helper.ControllerHelper;
import com.liyuan.zero.framework.helper.IocHelper;
import com.liyuan.zero.framework.util.ClassUtil;

/**
 * 加载相应的helper类
 * Created by liyuan on 2018/9/1
 */
public final class HelperLoader {
    private HelperLoader(){}

    public static void init(){
        Class<?>[] helperSet = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> helper :helperSet) {
            ClassUtil.loadClass(helper.getName());
        }
    }

}
