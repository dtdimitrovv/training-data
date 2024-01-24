package com.example.trainingdata.controller;

import com.example.authorizationValidator.config.argumentResolver.AuthenticatedPrincipal;
import com.example.authorizationValidator.security.IsAuthenticated;
import com.example.trainingdata.entity.Trainer;
import com.example.trainingdata.entity.TrainingDatum;
import com.example.trainingdata.payload.request.TrainingInfoRequest;
import com.example.trainingdata.service.trainingData.TrainingDataService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/records")
public class TrainingDataController {
    private final TrainingDataService trainingDataService;

    public TrainingDataController(TrainingDataService trainingDataService) {
        this.trainingDataService = trainingDataService;
    }

    @PostMapping("/{traineeId}")
    @IsAuthenticated
    public void createRecord(@AuthenticatedPrincipal Trainer trainer,
                             @PathVariable Long traineeId,
                             @RequestBody @Valid TrainingInfoRequest trainingInfoRequest) {
        this.trainingDataService.save(trainer, traineeId, trainingInfoRequest);
    }

    @GetMapping("/{traineeId}")
    @IsAuthenticated
    public Page<TrainingDatum> getAllByTraineeId(@PathVariable Long traineeId, Pageable pageable) {
        return this.trainingDataService.getAllByTraineeId(traineeId, pageable);
    }
}
