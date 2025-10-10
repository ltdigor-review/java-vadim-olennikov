package org.example.service;


import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToKafkaByChangeUser(User user) {
        kafkaTemplate.send("changeUser", user);
        log.info("send message to kafka topic by changeUser");
    }

    public void sendMessageToKafkaByCreateUser(User user) {
        kafkaTemplate.send("createUser", user);
        log.info("send message to kafka topic by createUser");
    }
}
