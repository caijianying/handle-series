package com.xiaobaicai.handle.spring.process.bean;

import com.xiaobaicai.handle.spring.process.annotations.Component;

/**
 * @author caijy
 * @description TODO
 * @date 2023/9/11 星期一 6:55 下午
 */
@Component("userService")
public class UserService {
    public void sayHello() {
        System.out.println("Hello!");
    }
}
