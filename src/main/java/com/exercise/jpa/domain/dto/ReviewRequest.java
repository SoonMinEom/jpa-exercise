package com.exercise.jpa.domain.dto;

import com.exercise.jpa.domain.entity.Hospital;
import com.exercise.jpa.domain.entity.Review;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private int id;
    private int hospital_id;
    private String title;
    private String content;
    private String patientName;

}
