package org.example.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UpdateUserRecord;
import org.example.dto.UserRecord;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserKafkaProducer userKafkaProducer;
    private final UserRepository userRepository;


    public UserRecord createUser(UserRecord userRecord) {

        Objects.requireNonNull(userRecord);

        UserEntity user = new UserEntity();
        user.setName(userRecord.name());

        userRepository.save(user);
        userKafkaProducer.sendMessageToKafkaByCreateUser(user);
        return userRecord;
    }

    @Transactional
    public UserRecord updateUser(UUID currentUserId, UpdateUserRecord updateUserRecord) {
        if (currentUserId == null || updateUserRecord.name() == null) {
            throw new IllegalArgumentException("User or new user is null");
        }

        UserEntity currentUser = userRepository
                .findBByUuid(currentUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + currentUserId));
        System.out.println(currentUser);
        currentUser.setName(updateUserRecord.name());
        System.out.println(currentUser);

        UserRecord userRecord = new UserRecord(currentUser.getName());

        userKafkaProducer.sendMessageToKafkaByChangeUser(currentUser);
        return  userRecord;
    }
}
