package com.xiaobaicai.spring.app.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author caijy
 * @description 演示Bean创建
 * @date 2023/7/22 星期六 2:25 下午
 */
@Slf4j
@EnableAspectJAutoProxy
public class TestBeanCreate {

    public TestBeanCreate() {
        log.info("TestService created...");
    }

}
