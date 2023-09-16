package com.xiaobaicai.handle.spring.process;

/**
 * @author caijy
 * @description TODO
 * @date 2023/9/11 星期一 7:19 下午
 */
public class BeanDefinition {

    private Class clazz;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
    }


}
