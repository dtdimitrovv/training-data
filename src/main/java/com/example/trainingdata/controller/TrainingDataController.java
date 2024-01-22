package com.example.trainingdata.controller;

import com.example.trainingdata.entity.Trainer;
import com.example.trainingdata.entity.TrainingDatum;
import com.example.trainingdata.payload.request.TrainingInfoRequest;
import com.example.trainingdata.service.TrainingDataService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/records")
public class TrainingDataController {
    private final TrainingDataService trainingDataService;

    public TrainingDataController(TrainingDataService trainingDataService) {
        this.trainingDataService = trainingDataService;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{traineeId}")
    public void createRecord(@AuthenticationPrincipal Trainer trainer,
                             @PathVariable Long traineeId,
                             @RequestBody @Valid TrainingInfoRequest trainingInfoRequest) {
        this.trainingDataService.save(trainer, traineeId, trainingInfoRequest);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{traineeId}")
    public Page<TrainingDatum> getAllByTraineeId(@PathVariable Long traineeId, Pageable pageable) {
        return this.trainingDataService.getAllByTraineeId(traineeId, pageable);
    }
}
