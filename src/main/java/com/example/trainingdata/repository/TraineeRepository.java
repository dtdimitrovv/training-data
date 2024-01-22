package com.example.trainingdata.repository;

import com.example.trainingdata.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
}
