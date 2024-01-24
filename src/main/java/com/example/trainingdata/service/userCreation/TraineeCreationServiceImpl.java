package com.example.trainingdata.service.userCreation;

import com.example.trainingdata.entity.Trainee;
import com.example.trainingdata.repository.TraineeRepository;
import org.springframework.stereotype.Component;

import static com.example.trainingdata.constant.UserTypeConstant.TRAINEE_USER_TYPE;

@Component(TRAINEE_USER_TYPE)
public class TraineeCreationServiceImpl implements UserCreationService {

    private final TraineeRepository traineeRepository;

    public TraineeCreationServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    @Override
    public void create(Long id) {
        this.traineeRepository.save(new Trainee(id));
    }
}
