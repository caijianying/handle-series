package com.xiaobaicai.spring.app;

import com.xiaobaicai.spring.app.bean.TestBeanCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author caijy
 * @Description Spring演示项目
 * @Date 2023/7/25 4:05 下午
 **/
@Slf4j
@SpringBootApplication
public class DemoApplication {

    /**
     * 演示配置类创建
     **/
    public DemoApplication() {
        log.info("DemoApplication created...");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 演示@Bean创建
     **/
    @Bean
    public TestBeanCreate testBeanCreate() {
        return new TestBeanCreate();
    }
}


