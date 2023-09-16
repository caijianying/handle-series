package com.xiaobaicai.handle.spring.process;


import com.xiaobaicai.handle.spring.process.bean.UserService;
import com.xiaobaicai.handle.spring.process.config.AppConfig;

/**
 * @author caijy
 * @description TODO
 * @date 2023/9/11 星期一 6:05 下午
 */
public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.sayHello();
    }
}
