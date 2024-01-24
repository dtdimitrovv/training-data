package com.example.trainingdata.repository;

import com.example.authorizationValidator.repository.AuthenticationEntityRepository;
import com.example.trainingdata.entity.Trainer;

public interface TrainerRepository extends AuthenticationEntityRepository<Trainer, Long> {
}
