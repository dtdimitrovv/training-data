package com.example.trainingdata.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    private Long id;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }
}
