package com.example.trainingdata.entity;

import com.example.authorizationValidator.entity.WithoutPrimaryKeyBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainees")
public class Trainee extends WithoutPrimaryKeyBaseEntity {
    public Trainee() {
    }

    public Trainee(Long id) {
        super(id);
    }
}
