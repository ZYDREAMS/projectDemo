package com.example.demo.kafka.kafkaService;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author zhaoyue
 * @date 2019/3/11 15:33
 * @description
 */
@Component
@Slf4j
public class KafkaReceiver {

    /**
     *  消费消息，@KafkaListener注解消费者一旦启动，就会监听kafka服务器上的topic，实时进行消费消息
     * @param record
     */
    @KafkaListener(topics = {"zhaoyue"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("消费消息---------- record =" + record);
            log.info("消费消息---------- message =" + message);
        }

    }

}
