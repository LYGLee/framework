package com.liyuan.zero.framework.bean;

/**
 * 返回数据对象
 * Created by liyuan on 2018/9/1
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
