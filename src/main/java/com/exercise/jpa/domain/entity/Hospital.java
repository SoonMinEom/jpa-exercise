package com.exercise.jpa.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospital2")
@Getter
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hospitalName;
    private String roadNameAddress;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();
}
