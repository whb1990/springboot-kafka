package com.wang.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wang.common.constant.Constant;
import com.wang.common.message.PayMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: whb
 * @date: 2019/6/20 15:26
 * @description: 消息生产者
 */
@Component
public class MessageProducer {
    private static Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    /**
     * 发送消息
     *
     * @param payMessage
     */
    public void sendMessage(PayMessage payMessage) {
        String msg = gson.toJson(payMessage);
        kafkaTemplate.send(Constant.PAY_TOPIC, msg);
        logger.info("生产者生产消息: send: message is: [" + msg + "]");
    }
}
