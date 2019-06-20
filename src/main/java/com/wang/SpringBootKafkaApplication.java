package com.wang;

import com.wang.common.message.PayMessage;
import com.wang.common.util.CommonUtils;
import com.wang.producer.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: whb
 * @date: 2019/6/20 15:25
 * @description: 启动类
 */
@SpringBootApplication
public class SpringBootKafkaApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootKafkaApplication.class, args);
        MessageProducer producer = applicationContext.getBean(MessageProducer.class);
        while (true) {
            PayMessage message = new PayMessage();
            message.setFee(CommonUtils.getFee());
            message.setOrderCode(CommonUtils.getNextCode());
            message.setSendTime(System.currentTimeMillis());
            producer.sendMessage(message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
