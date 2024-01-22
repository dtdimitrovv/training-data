package com.example.trainingdata.payload.request;

import jakarta.validation.constraints.NotBlank;

public record TrainingInfoRequest(@NotBlank String conditionBeforeTraining,
                                  @NotBlank String conditionDuringTraining,
                                  @NotBlank String conditionAfterTraining,
                                  @NotBlank String exercisesPerformed) {
}
