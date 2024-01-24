package com.example.trainingdata.entity;

import com.example.authorizationValidator.entity.WithoutPrimaryKeyBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainers")
public class Trainer extends WithoutPrimaryKeyBaseEntity {
    public Trainer() {
    }

    public Trainer(Long id) {
        super(id);
    }
}
