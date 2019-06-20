package com.wang.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wang.common.constant.Constant;
import com.wang.common.message.PayMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author: whb
 * @date: 2019/6/20 15:26
 * @description: 消息消费者
 */
@Service
public class MessageConsumer {

    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = Constant.PAY_TOPIC)
    public void onMessage(ConsumerRecord<?, ?> cr) {
        logger.error("****收到kafka消息****：" + cr.value() + "--" + cr);
        Object value = cr.value();
        PayMessage msg = gson.fromJson(value.toString(), PayMessage.class);
        logger.info("消费者消费消息: message is: [" + msg + "]");
    }
}
