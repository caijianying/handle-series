package com.xiaobaicai.handle.spring.step1.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author caijy
 * @description TODO
 * @date 2023/9/11 星期一 6:08 下午
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface Component {

    String value() default "";
}
