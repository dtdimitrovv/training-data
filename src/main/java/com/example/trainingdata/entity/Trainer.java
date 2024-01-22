package com.example.trainingdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainers")
public class Trainer extends BaseEntity {
    public Trainer() {
    }

    public Trainer(Long id) {
        super(id);
    }
}
