package org.example.service;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserRecord;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j

@Service
@Transactional
public class UserService {

    private final UserKafkaProducer userKafkaProducer;
    private final UserRepository userRepository;

    public UserService(UserKafkaProducer userKafkaProducer, UserRepository userRepository) {
        this.userKafkaProducer = userKafkaProducer;
        this.userRepository = userRepository;
    }

    /**
     * Create user.
     *
     * @param userRecord DTO for user.
     * @return RE<UserRecord>, status code.
     */
    public ResponseEntity<UserRecord> createUser(UserRecord userRecord) {

        if (userRecord == null) {
            throw new IllegalArgumentException("userRecord is null");
        }

        User user = new User();
        user.setName(userRecord.name());

        userRepository.save(user);
        userKafkaProducer.sendMessageToKafkaByCreateUser(user);

        return new ResponseEntity<>(userRecord, HttpStatus.CREATED);
    }

    public ResponseEntity<UserRecord> updateUser(Long currentUserId, Long newUserId) {
        if (currentUserId == null || newUserId == null) {
            throw new IllegalArgumentException("User or new user is null");
        }
        User currentUser = userRepository
                .findById(currentUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + currentUserId));

        userRepository.updateUserId(currentUserId, newUserId);
        userKafkaProducer.sendMessageToKafkaByChangeUser(currentUser);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
