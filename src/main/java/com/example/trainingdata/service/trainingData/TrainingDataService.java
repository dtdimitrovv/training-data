package com.example.trainingdata.service.trainingData;

import com.example.trainingdata.entity.Trainer;
import com.example.trainingdata.entity.TrainingDatum;
import com.example.trainingdata.payload.request.TrainingInfoRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrainingDataService {
    void save(Trainer trainer, Long traineeId, TrainingInfoRequest trainingInfoRequest);

    Page<TrainingDatum> getAllByTraineeId(Long traineeId, Pageable pageable);
}
