package com.example.trainingdata.repository;

import com.example.trainingdata.entity.TrainingDatum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingDatumRepository extends JpaRepository<TrainingDatum, Long> {
    Page<TrainingDatum> findByTrainee_Id(Long traineeId, Pageable pageable);
}
