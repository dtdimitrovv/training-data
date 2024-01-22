package com.example.trainingdata.service;

import com.example.trainingdata.entity.Trainer;
import com.example.trainingdata.entity.TrainingDatum;
import com.example.trainingdata.exception.InvalidTraineeIdException;
import com.example.trainingdata.payload.request.TrainingInfoRequest;
import com.example.trainingdata.repository.TraineeRepository;
import com.example.trainingdata.repository.TrainingDatumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrainingDataServiceImpl implements TrainingDataService {

    private final TraineeRepository traineeRepository;
    private final TrainingDatumRepository trainingDatumRepository;

    public TrainingDataServiceImpl(TraineeRepository traineeRepository, TrainingDatumRepository trainingDatumRepository) {
        this.traineeRepository = traineeRepository;
        this.trainingDatumRepository = trainingDatumRepository;
    }

    @Override
    public void save(Trainer trainer, Long traineeId, TrainingInfoRequest trainingInfoRequest) {
        this.traineeRepository.findById(traineeId)
                .ifPresentOrElse(trainee -> this.trainingDatumRepository.save(
                        new TrainingDatum(
                                trainingInfoRequest.conditionBeforeTraining(),
                                trainingInfoRequest.conditionAfterTraining(),
                                trainingInfoRequest.conditionDuringTraining(),
                                trainingInfoRequest.exercisesPerformed(),
                                trainer,
                                trainee
                        )
                ), () -> {
                    throw new InvalidTraineeIdException();
                });
    }

    @Override
    public Page<TrainingDatum> getAllByTraineeId(Long traineeId, Pageable pageable) {
        return this.trainingDatumRepository.findByTrainee_Id(traineeId, pageable);
    }
}
