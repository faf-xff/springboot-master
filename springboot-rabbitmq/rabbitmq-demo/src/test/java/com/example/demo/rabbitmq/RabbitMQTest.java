package com.example.demo.rabbitmq;

import com.example.demo.rabbitmq.service.oneToOne.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 路径：com.example.demo.rabbitmq
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/23 22:21
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private HelloSender testSender;

    /**
     * 方法名：
     * 功能：一对一发送
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/23 22:24
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void test() throws Exception{
        testSender.send();
    }

}
