package com.xiaobaicai.spring.app.circularReferences;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author caijy
 * @description CircularBeanB
 * @date 2023/8/2 星期三 3:52 下午
 */
@Slf4j
@Component
public class CircularBeanB {

    @Autowired
    CircularBeanA beanA;

    public CircularBeanB() {
        log.info("CircularBeanB created...");
    }

    public void invoke() {
        log.info("CircularBeanB invoked...");
    }
}
