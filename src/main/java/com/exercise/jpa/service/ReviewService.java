package com.exercise.jpa.service;

import com.exercise.jpa.domain.dto.ReviewRequest;
import com.exercise.jpa.domain.entity.Hospital;
import com.exercise.jpa.domain.entity.Review;
import com.exercise.jpa.repository.HospitalRepository;
import com.exercise.jpa.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewRequest add (ReviewRequest reviewRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(reviewRequest.getHospital_id());
        Review review = Review.builder()
                .title(reviewRequest.getTitle())
                .content(reviewRequest.getContent())
                .patientName(reviewRequest.getPatientName())
                .hospital(hospital.get())
                .build();

        Review savedReview = reviewRepository.save(review);
        return ReviewRequest.builder()
                .id(savedReview.getId())
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .build();

    }
}
