package com.example.trainingdata.kafka;

import com.example.trainingdata.service.userCreation.UserCreationServiceProvider;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    private final UserCreationServiceProvider userCreationServiceProvider;

    public ConsumerService(UserCreationServiceProvider userCreationServiceProvider) {
        this.userCreationServiceProvider = userCreationServiceProvider;
    }

    @KafkaListener(topics = "UserCreated", groupId = "group-id-training-service")
    public void createUser(@Header("User-Id") Long userId, @Header("User-Type") String userType) {
        this.userCreationServiceProvider
                .getByUserType(userType)
                .create(userId);
    }
}
