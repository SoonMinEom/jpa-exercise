package com.exercise.jpa.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "review2")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String patientName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
