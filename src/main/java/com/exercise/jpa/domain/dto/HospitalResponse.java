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
public class HospitalResponse {
    private int id;
    private String hospitalName;
    private String roadNameAddress;
    private List<Review> reviews;

    public static HospitalResponse of (Hospital hospital) {
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews())
                .build();
    }
}
