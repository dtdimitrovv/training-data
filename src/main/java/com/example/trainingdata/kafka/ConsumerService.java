package com.example.trainingdata.kafka;

import com.example.trainingdata.entity.Trainee;
import com.example.trainingdata.entity.Trainer;
import com.example.trainingdata.repository.TraineeRepository;
import com.example.trainingdata.repository.TrainerRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;

    public ConsumerService(
            TrainerRepository trainerRepository,
            TraineeRepository traineeRepository
    ) {
        this.trainerRepository = trainerRepository;
        this.traineeRepository = traineeRepository;
    }

    @KafkaListener(topics = "UserCreated", groupId = "group-id-training-service")
    public void createUser(@Header("User-Id") String userId, @Header("User-Type") String userType) {
        if (userType.equals("TRAINER")) {
            this.trainerRepository.save(new Trainer(Long.parseLong(userId)));
        } else {
            this.traineeRepository.save(new Trainee(Long.parseLong(userId)));
        }
    }
}
