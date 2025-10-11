package org.example.service;


import lombok.extern.slf4j.Slf4j;
import org.example.entity.UserEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaProducer {

    private final KafkaTemplate<String, UserEntity> kafkaTemplate;

    public UserKafkaProducer(KafkaTemplate<String, UserEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToKafkaByChangeUser(UserEntity user) {
        kafkaTemplate.send("changeUser", user);
        log.info("send message to kafka topic by changeUser");
    }

    public void sendMessageToKafkaByCreateUser(UserEntity user) {
        kafkaTemplate.send("createUser", user);
        log.info("send message to kafka topic by createUser");
    }
}
