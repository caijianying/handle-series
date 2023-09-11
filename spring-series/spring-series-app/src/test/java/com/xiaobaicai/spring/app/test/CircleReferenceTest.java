package com.xiaobaicai.spring.app.test;

import com.xiaobaicai.spring.app.circularReferences.CircularBeanA;
import com.xiaobaicai.spring.app.circularReferences.CircularBeanB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author caijy
 * @description TODO
 * @date 2023/8/3 星期四 3:03 下午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CircleReferenceTest {

    @Autowired
    CircularBeanA beanA;

    @Autowired
    CircularBeanB beanB;

    @Test
    public void test(){
        beanA.invoke();
    }

}
