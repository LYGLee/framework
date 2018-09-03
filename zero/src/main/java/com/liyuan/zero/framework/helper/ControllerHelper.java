package com.liyuan.zero.framework.helper;

import com.liyuan.zero.framework.annotation.Action;
import com.liyuan.zero.framework.bean.Handler;
import com.liyuan.zero.framework.bean.Request;
import com.liyuan.zero.framework.util.ArrayUtil;
import com.liyuan.zero.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 * Created by liyuan on 2018/9/1
 */
public final class ControllerHelper {
    private ControllerHelper(){}

    /**
     * 用于存放请求与处理器的映射关系
     */
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            //遍历所有的Controller类
            for (Class<?> controllerClass:controllerClassSet) {
                //获取Controller类中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    //遍历这些方法
                    for (Method method:methods ) {
                        //判断这些方法是否带有Action注解
                        if(method.isAnnotationPresent(Action.class)){
                            //从注解中获取URL映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证URL规则
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array)&&array.length==2){
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }

}
