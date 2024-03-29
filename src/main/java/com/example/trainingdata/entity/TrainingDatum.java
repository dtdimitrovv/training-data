package com.example.trainingdata.entity;

import com.example.authorizationValidator.entity.WithPrimaryKeyBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "training_data")
public class TrainingDatum extends WithPrimaryKeyBaseEntity {
    private String conditionBeforeTraining;
    private String conditionAfterTraining;
    private String conditionDuringTraining;
    private String exercisesPerformed;
    private Trainer trainer;
    private Trainee trainee;

    public TrainingDatum() {
    }

    public TrainingDatum(
            String conditionBeforeTraining,
            String conditionAfterTraining,
            String conditionDuringTraining,
            String exercisesPerformed,
            Trainer trainer,
            Trainee trainee
    ) {
        this.conditionBeforeTraining = conditionBeforeTraining;
        this.conditionAfterTraining = conditionAfterTraining;
        this.conditionDuringTraining = conditionDuringTraining;
        this.exercisesPerformed = exercisesPerformed;
        this.trainer = trainer;
        this.trainee = trainee;
    }

    public String getConditionBeforeTraining() {
        return conditionBeforeTraining;
    }

    public TrainingDatum setConditionBeforeTraining(String conditionBeforeTraining) {
        this.conditionBeforeTraining = conditionBeforeTraining;
        return this;
    }

    public String getConditionAfterTraining() {
        return conditionAfterTraining;
    }

    public TrainingDatum setConditionAfterTraining(String conditionAfterTraining) {
        this.conditionAfterTraining = conditionAfterTraining;
        return this;
    }

    public String getConditionDuringTraining() {
        return conditionDuringTraining;
    }

    public TrainingDatum setConditionDuringTraining(String conditionDuringTraining) {
        this.conditionDuringTraining = conditionDuringTraining;
        return this;
    }

    @ManyToOne
    public Trainer getTrainer() {
        return trainer;
    }

    public TrainingDatum setTrainer(Trainer trainer) {
        this.trainer = trainer;
        return this;
    }

    @ManyToOne
    public Trainee getTrainee() {
        return trainee;
    }

    public TrainingDatum setTrainee(Trainee trainee) {
        this.trainee = trainee;
        return this;
    }

    public String getExercisesPerformed() {
        return exercisesPerformed;
    }

    public TrainingDatum setExercisesPerformed(String exercisesPerformed) {
        this.exercisesPerformed = exercisesPerformed;
        return this;
    }
}
